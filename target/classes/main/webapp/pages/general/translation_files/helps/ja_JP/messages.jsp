<div style="page-break-after: always;"
<a name="top"></a>
<br><br>Cyclos内のメッセージは、すべてのタイプのユーザー間で、非常に様々な場合に使われ得ます。
メンバーやグループの間でメッセージを送信するための、多くの柔軟な機能が利用可能です。
異なるメッセージのカテゴリーを定めることも可能で、その場合、特定のグループに特定のメッセージのカテゴリーを与えられます。<br>
メッセージは、Cyclos内の内部メッセージングシステムを通じて送信されます。
これは受取人がログインするや否や、あなたが送信したメッセージを目にするということを意味します。
Cyclosは、これらのメッセージがE-mailによっても送信されるように<a
	href="${pagePrefix}notifications"><u>設定</u></a>できますが、
これを許可するかしないかは、受信者の責任です。
メッセージがE-mailによって送信されたことを確認したいならば、直接E-mailを使うべきでしょう。
しかしながら、これは、Cyclosのインタフェースを通じて実行できます。
そのインタフェースは、各々のメンバープロフィール内に「E-mailを送信する」ボタンを含んでいます。
<i>どこで見つけられる？</i><br>
<span class="member">あなたは、「メニュー: パーソナル > メッセージ」を通じて、メッセージにアクセスできます。</span>
<span class="admin">あなたは、「メニュー: メッセージ > メッセージ」を通じて、メッセージにアクセスできます。</span>
<span class="broker">仲介者として（あなたのメンバー全員に対して）メッセージを送信するためにも、「メニュー: パーソナル > メッセージ」を使えますが、
「メニュー: 仲介 > メンバーへのメッセージ」オプションを使ってもよいでしょう。
</span>
メッセージを送信する別な方法は、メンバーの
<a href="${pagePrefix}profiles"><u>プロフィール</u></a>に行き、
<span class="admin">「メンバー情報」セクション内の</span>「メッセージを送信する」ボタンをクリックする方法です。
<span class="admin">
<br><br><i>どうやって動かす？</i><br>
メッセージを可能にするための許可を設定する必要があります。
管理者の場合は、「メッセージ」ブロック下で
<a href="${pagePrefix}groups#manage_group_permissions_admin_member"><u>許可</u></a>を設定して下さい。
これにより、メンバーに対してメッセージを送信するための様々な許可を設定することができます。<br>
メッセージに関する
<a href="${pagePrefix}groups#manage_group_permissions_member"><u>メンバーに対する許可</u></a>は、「メッセージ」というタイトルのブロックの下に見つけられます。<br>
仲介者は、彼らが仲介するメンバーに対するメッセージ送信に関する一組の追加的な
<a href="${pagePrefix}groups#manage_group_permissions_broker"><u>
許可</u></a>を持っており、
それらは「パーソナルメッセージ」ブロック下で見つけられます。
</span>
<hr>

<A NAME="messages_search"></A>
<h3>メッセージリスト</h3>
このページでは、あなたが送信または受信した<a href="#top"><u>メッセージ</u></a>
を見ることを選択できます。
ドロップダウン選択で、「受信ボックス」フォルダ、「送信済みアイテム」フォルダ、または「ゴミ箱」フォルダを見ることができます。<br>
<span class="admin">
「カテゴリー」ドロップダウンで具体的なカテゴリーを選択することもできます。
（注: カテゴリーがそのリスト内に現れるようにするには、あなたは少なくとも、そのカテゴリーを見る許可を持っている必要があります。）<br></span>
「詳細検索」ボタンをクリックすることにより、キーワード、または、そのメッセージの送信元や送信先でメッセージを検索できます。
検索項目を記入し終えたら、「送信」ボタンをクリックしなければなりません。
<br><br>新しいメッセージを送信するためには、「新しいメッセージを送信する」というラベルの付いた送信ボタンをクリックしなければなりません。
<hr class="help">

<A NAME="messages_search_result"></A>
<h3>メッセージ検索結果</h3>
このページは、<a href="#messages_search"><u>上のウィンドウ</u></a>で指定された条件に基づいて<a href="#top"><u>メッセージ</u></a>を表示します。

<br><br>アイコンはそのメッセージの状態を示します。以下のいずれかです:
<ul>
	<li><img border="0" src="${images}/message_unread.gif"
		width="16" height="16">&nbsp;（未読）
	<li><img border="0" src="${images}/message_read.gif"
		width="16" height="16">&nbsp;（既読）
	<li><img border="0" src="${images}/message_replied.gif"
		width="16" height="16">&nbsp;（返信済み）
	<li><img border="0" src="${images}/message_removed.gif"
		width="16" height="16">&nbsp;（削除済み）
</ul>
以下のアクションを実行できます:
<ul>
	<li>件名を選択することにより、メッセージを開けます。
	<li>チェックボックスで複数のメッセージを選択し、
	メッセージウィンドウの下のドロップダウン選択内でアクションを選択することにより、
	それらのメッセージに対してアクションを適用できます。
	<li>直接、消去アイコン(
	<img border="0" src="${images}/delete.gif" width="16" height="16">&nbsp;)を選択することにより、単一のメッセージを削除できます。
</ul>
<hr class='help'>

<A NAME="messages_send"></A>
<h3>メッセージを送信する</h3>
<span class="admin"> 
	ここでは、メンバーに対して<a href="#top"><u>メッセージ</u></a>を送信できます。
	メッセージ機能（「メニュー: メッセージ > メッセージ」）内からメッセージを送信する場合、ログイン名フィールドと／またはメンバーフィールド（自動補完付き）でメンバーを指定しなければなりません。
	そのメッセージのためのカテゴリーを指定しなければなりません。<br>
	<br><br>グループに対してメッセージを送信する場合、そのフォームは変化し、使用すべき他の編集ボックスがあるでしょう。
	あなたは、まず、「グループ」マルチドロップダウンから1つ以上のグループを選択しなければなりません。あなたが選択したグループ内のすべてのメンバーが、そのメッセージを受け取ります。
	<br>グループに対して送信する場合、あなたはプレーンフォーマットまたはリッチテキストで送信することができます。
	後者は、フォントや画像など、レイアウトのための特別な機能を使うことができます。
	そのためには、ラジオボタンで「リッチテキスト」オプションを選ばなければなりません。すると、リッチテキストエディタが現れ、レイアウトのための様々なボタンを使えるようになります。（まずはそれを試しに少し使ってみて下さい。）
	リッチテキストエディタの「ソース」ボタンをクリックすることにより、プレーンhtmlを使うこともできます。<br>
	画像を含めたいならば、まず「（メニュー: コンテンツ管理 > <a href="${pagePrefix}content_management#custom_images"><u>
	カスタム画像</u></a>）」セクション内でそれをアップロードしなければなりません。
<br>
	管理者として、あなたは別の管理者にメッセージを送信することはできません。
</span>
<span class="member">
	ここでは、メンバーか管理者に対して<a href="#top"><u>メッセージ</u></a>を送信できます。
</span>
<span class="broker">
	ここでは以下の者に対してメッセージを送信できます:
	<ul>
		<li>特定のメンバー
		<li>あなたの登録済みメンバー全員
		<li>管理者
	</ul> 
</span>
<span class="member">
	このフォームは非常に分かり易いものです。
	「メンバー」を選んだ場合、名前またはログイン名のいずれかによって、	そのメンバーを指定しなければなりません。
	ログイン名を記入すると、実名が自動的に与えられます。<br>
	「管理者」を選んだ場合、あなたのメッセージのためのカテゴリーを指定しなければなりません。<br>
</span>
<span class="broker">
	「私の登録済みメンバー」を選んだ場合、「プレーン」フォーマットまたは「リッチテキスト」フォーマットでメッセージを書くことができます。
	後者は、フォント、画像など、レイアウトのための特別な機能を使えます。
	そのためには、ラジオボタンで「リッチテキスト」オプションを選ばなければなりません。
	すると、リッチテキストエディタが現れ、レイアウトのための様々なボタンを使えるようになります。（まずはそれを試しに少し使ってみて下さい。）
	リッチテキストエディタの「ソース」ボタンをクリックすることにより、プレーンhtmlを使うこともできます。<br>
</span>
メッセージを仕上げたら、「送信」をクリックすると送信されます。
そのメッセージは、あなたの「送信済みアイテム」ボックス内に現れるでしょう。
<hr class='help'>

<span class="broker">
<a name="messages_send_brokered_members"></a>
<h3>メッセージを送信する</h3>
	ここでは、あなたの登録済みメンバー全員に対してメッセージを送信できます。このフォームは非常に分かり易いものです。
	<br><br>あなたは、「プレーン」フォーマットまたは「リッチテキスト」フォーマットでメッセージを書くことができます。
	後者は、フォント、画像など、レイアウトのための特別な機能を使えます。
	そのためには、ラジオボタンで「リッチテキスト」オプションを選ばなければなりません。
	すると、リッチテキストエディタが現れ、レイアウトのための様々なボタンを使えるようになります。（まずはそれを試しに少し使ってみて下さい。）
	リッチテキストエディタの「ソース」ボタンをクリックすることにより、プレーンhtmlを使うこともできます。<br>
メッセージを仕上げたら、「送信」をクリックすると送信されます。
そのメッセージは、あなたの「送信済みアイテム」ボックス内に現れるでしょう。
<hr class="help">
</span>

<A NAME="messages_view"></A>
<h3>メッセージを見る</h3>
これは<a href="#top"><u>メッセージ</u></a>です。
「ゴミ箱に移動する」というラベルの付いた送信ボタンをクリックすることにより、
メッセージを削除して「ゴミ箱」に移動できます。
このゴミ箱の中のメッセージは、<a href="#messages_search"><u>メッセージ概観</u></a>の中の「ゴミ箱」を開くだけで、常に読み返すことができます。<br> 
「返信」ボタンをクリックすることにより、メッセージに返信できます。
（そのメッセージがあなたによって送信されたならば、返信ボタンはありません。）
<hr class="help">

<a name="categories"></a>
<h2>メッセージカテゴリー</h2>
<a href="#top"><u>メッセージ</u></a>カテゴリーは、管理者に送信されたメッセージをうまく管理できるようにします。
カテゴリーは、メンバーと管理者の間のメッセージについてのみ存在します。
メンバーからメンバーへのメッセージは、カテゴリーを使用しません。

<hr>

<span class="admin">
<A NAME="message_categories"></A>
<h3>メッセージカテゴリー</h3>
このページは、<a href="#top"><u>メッセージ</u></a>のための<a href="#categories"><u>カテゴリー</u></a>のリストを示します。
<br><br>
<ul>
	<li><img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;
	そのカテゴリーの修正を可能にします。
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">&nbsp;
	そのカテゴリーの削除を可能にします。
	これはそれが未だ使われていない場合にのみ可能です。
	<li>新しいカテゴリーを作成するには、「新しいメッセージカテゴリーを挿入する」というラベルの付いた送信ボタンを使って下さい。
</ul>
<hr class='help'>
</span>

<span class="admin">
<a name="edit_message_category"></a>
<h3>メッセージカテゴリーを修正する</h3>
このウィンドウにより、<a href="#top"><u>メッセージ</u></a>のための
<a href="#categories"><u>
カテゴリー</u></a>の名称を変更することができます。
何か説明的なものを選んで下さい。
これはメンバーが<a href="#messages_send"><u>メッセージ送信ウィンドウ</u></a>内で目にすることになります。
<br>
いつものように、変更をするために「変更」をクリックし、完了したら、変更点を保存するために「送信」ボタンをクリックして下さい。
<hr class="help">
</span>

<span class="admin">
<a name="new_message_category"></a>
<h3>新しいメッセージカテゴリーを挿入する</h3>
このウィンドウにより、<a href="#top"><u>メッセージ</u></a>のための
新しい<a href="#categories"><u>カテゴリー</u></a>を挿入することができます。
いくらかの説明的な名称を入力し、変更点を保存するためのに「送信」ボタンをクリックして下さい。<br>
メンバーは、<a href="#messages_send"><u>
メッセージ送信ウィンドウ</u></a>内で、この名称を目にすることになります。
<hr class="help">
</span>

</div> <%--  page-break end --%>

<div class='help'>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
</div>