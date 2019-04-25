/*
    This file is part of Cyclos (www.cyclos.org).
    A project of the Social Trade Organisation (www.socialtrade.org).

    Cyclos is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Cyclos is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Cyclos; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 */
package nl.strohalm.cyclos.utils.customizedfile;

import nl.strohalm.cyclos.entities.customization.images.Image;

import org.springframework.beans.factory.InitializingBean;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.MessageListener;

/**
 * A customized file handler which broadcasts operations using Hazelcast
 * 
 * @author luis
 */
public class HazelcastCustomizedFileHandler extends BaseCustomizedFileHandler implements InitializingBean {

    private ITopic<CustomizedFileOperation> customizedFilesTopic;
    private ITopic<Image>                   imageChangesTopic;

    @Override
    public void afterPropertiesSet() throws Exception {
        customizedFilesTopic = Hazelcast.getTopic("cyclos.CustomizedFiles");
        customizedFilesTopic.addMessageListener(new MessageListener<CustomizedFileOperation>() {
            @Override
            public void onMessage(final CustomizedFileOperation operation) {
                onCustomizedFileMessage(operation);
            }
        });
        imageChangesTopic = Hazelcast.getTopic("cyclos.ImageChanges");
        imageChangesTopic.addMessageListener(new MessageListener<Image>() {
            @Override
            public void onMessage(final Image image) {
                onImageMessage(image);
            }
        });
    }

    @Override
    public synchronized void delete(final String path) {
        // The local instance receives the event too - so, no need to manually call deleteLocally
        publish(CustomizedFileOperation.forDelete(path));
    }

    @Override
    public void notifyImageChangeListeners(final Image image) {
        imageChangesTopic.publish(image);
    }

    public void onCustomizedFileMessage(final CustomizedFileOperation operation) {
        LOG.debug("Executing received customized file event: " + operation.getType());
        switch (operation.getType()) {
            case DELETE:
                deleteLocally(operation.getPath());
                break;
            case WRITE:
                writeLocally(operation.getPath(), operation.getLastModified(), operation.getContents());
                break;
        }
    }

    @Override
    public synchronized void write(final String path, final long lastModified, final byte[] contents) {
        // The local instance receives the event too - so, no need to manually call writeLocally
        publish(CustomizedFileOperation.forWrite(path, lastModified, contents));
    }

    private void onImageMessage(final Image image) {
        notifyImageChangeListenersLocally(image);
    }

    private void publish(final CustomizedFileOperation operation) {
        LOG.debug("Publishing customized file event: " + operation);
        customizedFilesTopic.publish(operation);
    }

}
