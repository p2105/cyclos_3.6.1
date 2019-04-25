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
package nl.strohalm.cyclos.services.accounts.external;

import java.util.List;

import nl.strohalm.cyclos.access.AdminSystemPermission;
import nl.strohalm.cyclos.entities.Relationship;
import nl.strohalm.cyclos.entities.accounts.external.ExternalAccount;
import nl.strohalm.cyclos.entities.accounts.external.ExternalTransferType;
import nl.strohalm.cyclos.entities.exceptions.EntityNotFoundException;
import nl.strohalm.cyclos.services.BaseServiceSecurity;

/**
 * Security implementation for {@link ExternalTransferTypeService}
 * 
 * @author jcomas
 */
public class ExternalTransferTypeServiceSecurity extends BaseServiceSecurity implements ExternalTransferTypeService {

    private ExternalTransferTypeServiceLocal externalTransferTypeService;

    @Override
    public List<ExternalTransferType> listByAccount(final ExternalAccount account) {
        permissionService.permission().admin(AdminSystemPermission.EXTERNAL_ACCOUNTS_VIEW).check();
        return externalTransferTypeService.listByAccount(account);
    }

    @Override
    public ExternalTransferType load(final Long id, final Relationship... fetch) throws EntityNotFoundException {
        permissionService.permission().admin(AdminSystemPermission.EXTERNAL_ACCOUNTS_VIEW).check();
        return externalTransferTypeService.load(id, fetch);
    }

    @Override
    public int remove(final Long... ids) {
        permissionService.permission().admin(AdminSystemPermission.EXTERNAL_ACCOUNTS_MANAGE).check();
        return externalTransferTypeService.remove(ids);
    }

    @Override
    public ExternalTransferType save(final ExternalTransferType externalTransferType) {
        permissionService.permission().admin(AdminSystemPermission.EXTERNAL_ACCOUNTS_MANAGE).check();
        return externalTransferTypeService.save(externalTransferType);
    }

    public void setExternalTransferTypeServiceLocal(final ExternalTransferTypeServiceLocal externalTransferTypeService) {
        this.externalTransferTypeService = externalTransferTypeService;
    }

    @Override
    public void validate(final ExternalTransferType externalTransferType) {
        // Nothing to check.
        externalTransferTypeService.validate(externalTransferType);
    }

}
