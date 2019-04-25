<div style="page-break-after: always;"
<span class="admin">
<br><br>
Cyclosは様々な言語をサポートしており、あなたが翻訳を管理することが可能です。
エンドユーザーに対して表示されるすべてのテキストは、言語固有のファイル（各言語について1つ）と、より大きなテキストブロックのための限られた数の静的テキストファイルの中に含まれています。<br>
Cyclosには、選択可能な多くの言語が備わっており、設定メニューを通じて、少しのマウスクリックであなたのインストールの言語を変更できます。<br>
あなたがCyclosに備わっている翻訳に満足しない場合は、Cyclos内の各々の個々のテキストまたは用語を修正することもできます。
このモジュールは、
Cyclosシステムを通じて送信されるすべてのメッセージと送信されるすべてのE-mail通知を維持するためのセクションも含みます。
<i>どこで見つけられる？</i><br>
翻訳モジュールには、「メニュー: 翻訳」を通じてアクセスできます。
以下のサブメニュー項目が利用可能です:
<ul>
	<li><b><a href="#translation_keys"><u>アプリケーション</u></a>:</b>
	アプリケーションウィンドウ内に現れるすべての小さなテキスト用語の翻訳を管理できます。
	<li><b><a href="#notifications"><u>通知</u></a>:</b>
	システムによって送信される通知を管理できます。
	<li><b>E-mail:</b> システムによって送信されるE-mailのテキストを管理できます。
	<li><b>インポート／エクスポート:</b> 翻訳ファイルのインポートまたはエクスポートが可能です。
	これにより、Cyclosのコミュニティが他のCyclosユーザーと翻訳を共有できます。
</ul>
注1: 連絡先やお知らせページのような静的テキストファイルは、翻訳モジュールを通じて管理されません。それらは<a
	href="${pagePrefix}content_management"><u>コンテンツ管理</u></a>を通じて管理できます。
<br><br>
注2: Cyclosの言語を変更したい場合は、ここではありません。言語は<a
	href="${pagePrefix}settings#local"><u>メニュー: 設定 > ローカル設定</u></a>内の「国際化」ブロックで変更できます。<br> 
<hr>

<a name="translation_keys"></a>
<h2>翻訳キー</h2>
Cyclosのインタフェース内に現れる任意の短い書かれたテキストは、言語ファイル内に保持されており、各々の言語につき1つ存在します。
Cyclosのインタフェースにより、言語ファイル全体を置き換えるか、そのファイル内の各々のキーを個別に編集することができます。

アプリケーションページ内に位置する<a href="#key"><u>キー</u></a>は、<a href="#language_file"><u>言語ファイル</u></a>内には見つかりません。そのページ内に現れるキーは、クエスチョンマークの間に示されます。これはたいていこのように見えます: 「???translationMessage.search.showOnlyEmpty???」。
そのような場合、「メニュー: 翻訳 > アプリケーション」を通じて、あなた自身で言語ファイルにキー（とその値）を追加できます。
<br><br>あなたがブラウザウィンドウ内に現れる翻訳に満足できない場合には、それを改造できます。以下の手順に従ってください:
<ol>
	<li>（「メニュー: 翻訳 > アプリケーション」を通じて）翻訳用語の検索ページに行き、そこで「値」編集ボックス内にあなたが改造したい用語を入力して下さい。
	その用語は、大文字・小文字の区別がなく、プログラムはあなたがその用語の一部分のみを入力すると合致するものを探します。
	結果を表示するために、「検索」をクリックして下さい。
	<li>結果ページでは、修正アイコン（<img border="0"
		src="${images}/edit.gif" width="16" height="16">&nbsp;）をクリックして、値を変更して下さい。
</ol>
<br><br>ファイルからキー／値の組全体を追加または消去することもできます。
しかし、これは少し慎重を要するので、あなたはこれに関して<a href="#caution"><u>警告の注</u></a>を読みたいかもしれません。
<hr>

<a name="caution"></a>
<h3>言語キーの追加／削除についての警告</h3>
Cyclosのインタフェースにより、あなたは、<a href="#language_file"><u>言語ファイル</u></a>からの言語<a href="#key"><u>
キー</u></a>を修正、追加、または削除できます。
それらのキーの修正は安全なアクションですが、キーの追加または削除は少し慎重を要します。
それは言語キーについてのシステムがどのように機能するかを、あなたが完全に理解してる場合にのみ行うべきです。<br>
削除されたキーは、言語ファイルそれ自体からのみ削除されます。
それはアプリケーションページからは削除されません。
そのキーがアプリケーションページで依然として使われている場合、次回そのページはただクエスチョンマークに挟まれたキー名のみを表示するでしょう。
これはたいていあまり美しくありません（例えば: &quot;???about.bla.something.title???&quot;）。<br>
逆もまた同様です: 言語ファイルへのキーの追加は、あなたがそのキーをどこかで使い始めないと、何の手助けにもなりません。
あなたは<a
	href="${pagePrefix}content_management"><u>アプリケーションページのカスタマイズ</u></a>によってこれを行えます。<br>
アップデート後にキーが失われるということを起こり得ます。もっとも、それは非常に希です。
通常のCyclosのアップデートは、新しい翻訳キーを追加します。
そのような場合、あなたはキーをあなた自身で安全に追加できます。
<hr class="help">


<A NAME="application"></A>
<h3>翻訳キーを検索する</h3>
このウィンドウでは、<a href="#key"><u>翻訳キー</u></a>を検索できます。<br>
適切な編集ボックス内に、そのキーまたは<a href="#value"><u>値</u></a>を入力して下さい。
その検索は大文字・小文字の区別がなく、用語全体を入力する必要がないことに注意して下さい。その検索は、部分的に合致するものも含みます。
あなたは、いつものように、何も入力せずにただ「検索」を押すかもしれません。これは結果ボックス内にすべての利用可能なキー／値のペアを返します。<br>
「空の値のみ」チェックボックスを選択すると、翻訳を持たないキーのみが表示されます。（それはアップデート後に生じたかもしれません。）<br>
検索結果は、下の<a href="#application_results"><u>検索結果リストウィンドウ</u></a>内に現れます。
そのウィンドウでは、キーごとに翻訳を変更可能です。
<br><br>新しい翻訳キーを追加することも可能です。
そうしたいならば、「新しいキーを挿入する」というラベルの付いた送信ボタンをクリックして下さい。
あなたは、まず、これに関する<a href="#caution"><u>警告の注</u></a>を読みたいかもしれません。
<br><br>
注: Cyclosの言語を変更したいならば、ここではありません。
言語は、<a
	href="${pagePrefix}settings#local"><u>メニュー: 設定 > ローカル設定</u></a>内の「国際化」ブロックで変更できます。<br> 
<hr class="help">

<a name="application_results"></a>
<h3>検索結果（翻訳キー／値の）</h3>
このウィンドウは、<a
	href="#application"><u>上野ウィンドウ</u></a>内で定めたように、検索結果を表示します。
<br>
このウィンドウでは、キーを選択したり、それを（<img border="0"
	src="${images}/delete.gif" width="16" height="16">&nbsp; 消去アイコンによって）消去したり、それを（<img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;
編集アイコンによって）編集したりすることができます。
複数のキーを消去したい場合、チェックボックスで1つ以上を選択できます。
それから、「選択された項目を削除する」ボタンを使って下さい。<br><br>
キーの消去は慎重を要するということに注意して下さい。
あなたはまずこれについての<a href="#caution"><u>警告の注</u></a>を読みたいかもしれません。
<hr class="help">

<A NAME="edit_key"></A>
<h3>翻訳キーを修正する</h3>
このウィンドウでは、翻訳<a href="#key"><u>キー</u></a>の<a href="#value"><u>値</u></a>を修正できます。
まず「変更」をクリックして変更をし、それから「送信」をクリックして変更点を保存して下さい。<br>
複数行を使うことができますが、たいていそれは無視され、結果は単一の行で表示されます。
<hr class="help">

<A NAME="insert_key"></A>
<h3>新しい翻訳キー</h3>
ここでは、新しい翻訳<a href="#key"><u>キー</u></a>と<a
	href="#value"><u>値</u></a>を入力できます。
それらを編集ボックス内に入力し、「送信」をクリックして下さい。
新しい翻訳キーを追加する前に、これについての<a href="#caution"><u>警告の注</u></a>を読むことを勧めます。
<hr class="help">

<A NAME="import_file"></A>
<h3>翻訳ファイルをインポート／エクスポートする</h3>
このウィンドウでは、<a href="#language_file"><u>言語ファイル</u></a>を<a href="#import"><u>インポート</u></a>または<a href="#export"><u>
エクスポート</u></a> a できます。
さらなる情報については、リンクを辿って下さい。
<hr class="help">

<a name="import"></a>
<h3>言語ファイルをインポートする</h3>
このウィンドウ内の上の長方形は、新しい<a
	href="#language_file"><u>言語ファイル</u></a>をインポートするためのものです。
これは、例えばCyclosに新しい言語を追加する時など、稀な場合です。
通常のCyclosのアップデートは、新しい翻訳<a href="#key"><u>キー</u></a>を（もしあれば）自動的に追加します。
<br><br>まず、「何をするか」を決める必要があります。4つのオプションがあります:
<ul>
	<li><b>新しいキーのみをインポートする:</b> これは新しいキーをインポートして既存のキーをそのまま残します。
	<li><b>新しいキーと空のキーのみをインポートする:</b> 前の項目と同じですが、今度は空のキー（つまり: おそらく翻訳が完全には終わっていないために値が空であるキー）もインポートします。
	<li><b>新しいキーと修正されたキーをインポートする:</b> これは新しいキーと修正されたキーをインポートします。
	それは、あなたが一部のキーの値をあなた自身で修正した場合、それらは「標準」の値で上書きされるということを意味します。
	もはや使われていないキーは削除されます。
	<li><b>ファイル全体を置き換える:</b> これはファイル全体を上書きします。
	過去にあなたによって行われたすべてのカスタマイゼーションは、もちろん失われるでしょう。
</ul>
この後、あなたのコンピュータのローカルに保存されている翻訳ファイルへと「ブラウズ」して、「送信」をクリックしなければなりません。
<br><br>注: インポートするファイルがすべてのキーを含む必要はありません。もちろん、あなたが「ファイル全体を置き換える」を選ぶ場合は別です。
その他のすべての場合では、どのくらいの量のキーでも構いません。（しかし、それは正しいフォーマットでなければなりません。）<br>
ファイル全体を置き換えたいならば、確実にファイル全体をアップロードするようにして下さい。
さもないと、既存のキーを失う危険があります。

<h3>言語ファイルをエクスポートする</h3>
現在の<a href="#language_file"><u>
言語定義</u></a>をエクスポートするためのフォームの部分は、非常に単純です: 単に「プロパティーファイルとしてエクスポートする」というラベルの付いた「送信」ボタンを使って下さい。
このボタンをクリックすると、ブラウザが引き継ぎ、通常、あなたがそのファイルを保存したいかどうか尋ねます。
<br>
言語ファイルのエクスポートは稀な場合です: あなたは、他のCyclosコミュニティのユーザーがあなた自身のCyclosの翻訳を利用可能なようにしたい場合に、これを行いたいでしょう。
あなた自身の翻訳を作成したならば、是非、私たちに連絡して、あなたの翻訳を利用可能にして下さい。
私たちは、公式のCyclosディストリビューションにあなたの翻訳を加えることができます。
連絡先アドレスについては、プロジェクトのサイトを見て下さい（<a href="http://project.cyclos.org"><u>http://project.cyclos.org</u></a>）。
<hr class="help">

<a name="notifications"></a>
<h2>通知</h2>
Cyclosでは、以下のウィンドウで様々な通知の内容を管理できます。
<hr>

<A NAME="general_notifications"></A>
<h3>一般的な通知</h3>
このウィンドウは、一般的な<a href="${pagePrefix}notifications"><u>
通知</u></a>を表示します。
通常、これらは出て行くメールに追加される接頭辞と接尾辞です。
あなたは、編集アイコン（<img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;）をクリックすることにより、その内容を変更できます。.
<hr class="help">

<A NAME="member_notifications"></A>
<h3>メンバー通知</h3>
このウィンドウは、様々な場合にメンバーに送信される<a href="${pagePrefix}notifications"><u>
通知</u></a>を示します。
あなたは、編集アイコン（<img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;）をクリックすることにより、その内容を変更できます。
<hr class="help">

<A NAME="admin_notifications"></A>
<h3>管理者通知</h3>
このウィンドウは、様々な場合に管理者に送信される<a href="${pagePrefix}notifications"><u>
通知</u></a>を示します。
あなたは、編集アイコン（<img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;）をクリックすることにより、その内容を変更できます。
<hr class="help">

<A NAME="edit_notifications"></A>
<h3>通知を編集する</h3>
このウィンドウにより、あなたは通知の内容を変更できます。
これを行うには、まず（いつものように）「変更」ボタンをクリックして下さい。完了すると、「送信」をクリックすることにより変更点を保存できます。<br>
リッチテキストエディタが現れ、それにより、いくつかのレイアウト機能を使えます。
あなたは、あなたが修正する通知に応じて、いくつかのフィールドを使ってもよいでしょう。
<%-- Hoe kan ik weten welke?? --%>
<hr class="help">


<A NAME="mail_translation"></A>
<h3>メール翻訳</h3>
このウィンドウにより、あなたは、特定の場合に送信されるメールメッセージの内容を変更できます。
これを行うには、まず（いつものように）「変更」をクリックして下さい。完了したら、「送信」をクリックすることにより、変更点を保存できます。<br>
現時点では、以下のメールを変更できます:
<ul>
	<li><b>招待メール:</b> 「メニュー: ホーム > 招待」を通じて、<a href="${pagePrefix}home#home_invite"><u>友人を招待する</u></a>オプションを使う時に送信されるメール。
	<li><b>アクティベーションメール:</b> メンバーがアクティブ化された時に送信されるメール。
	これは、登録後、そのメンバーを「<a href="${pagePrefix}groups#inactive_members"><u>
	保留中のメンバー</u></a>」グループから、別のグループ（通常、完全なメンバー）へと移動することにより、管理者がそのアカウントをアクティブ化する時に起こります。
	<li><b>一般登録確認E-mail:</b> 潜在的なメンバーが初めて登録しようとする時に送信されるメール。このメールを送信するためには、Cyclosを<a href="${pagePrefix}notifications"><u>
	このために設定</u></a>しなければなりません。
	<li><b>リセットパスワードメール:</b> 誰かが彼のパスワードをリセットしたい時に送信されるメール。
</ul>
これらの定義のすべてにおいて、あなたは、テキスト内にデータを表示するためのフィールドを使えます。
<%-- hoe?? welke?? --%>
<hr class="help">

<a name="imexport_notifications_mails"></a>
<h3>通知とE-mailの翻訳をインポート／エクスポートする</h3>
このウィンドウで、あなたはメールと通知の翻訳済みテキストをファイルからインポート／ファイルにエクスポートできます。
ファイルはXMLフォーマットで、この（あるいは将来の）バージョンのCyclosの他のどのインスタンスでも読み込むことができます。<br>
あなたは、Cyclosのインスタンス間で翻訳を共有するため、あるいは、セキュリティ上の理由のために、これを行いたいかもしれません。<br>
そのフォームは、非常に分かり易いものです。
「インポート」を選ぶ場合、「ブラウズ」ボタンによってファイルを指定して下さい。
ファイルをエクスポートする場合、ブラウザが引き継ぎ、そのダウンロードをどこに保存するかをあなたに尋ねます。
<hr class="help">

<br><br><a name="glossary"></a>
<h2>用語集</h2>
<br><br>

<a name="language_file"></a> <b>言語ファイル</b>
<br><br>Cyclos内では、各々の言語について、1つの言語ファイルがあります。
このファイルは、Cyclosのインタフェース内に現れる、すべての書かれたテキスト「文字列」を含みます（完全なファイルに備わる大きなブロックのテキストを除く）。<br>
言語ファイルは、常に特定のパターンに従って名付けられています: 
「ApplicationResources_xx_XX.properties」で、xxは言語コード、XXは国コードによって置き換えられます。
例: 「ApplicationResources_en_US.properties」は、US-英語のためのファイルです。<br>
言語ファイルは、<a href="#key"><u>キー</u></a>と<a href="#value"><u>値</u></a>を含みます。
これらは「;」記号によって、スペースなしで区切られています。
<hr class='help'>

<a name="key"></a> <b>翻訳キー</b>
<br><br>翻訳キーは、アプリケーションページ内に位置します。それらのページがあなたのブラウザ内で表示される際に、キーは<a
	href="#language_file"><u>言語ファイル</u></a>内で探し出され、そのファイル内で見つかった<a href="#value"><u>値</u></a>によって置き換えられます。
<hr class='help'>

<a name="value"></a> <b>翻訳値</b>
<br><br>翻訳値は、あなたがブラウザ内のCyclosのページ上で見ることになる、あなた自身の言語の単語や用語です。
元のページは、これらの値を含みません。
その代わりに、翻訳<a href="#key"><u>キー</u></a>はアプリケーションページ内に置かれます。それらのページがあなたのブラウザ内に表示される際に、 キーは<a href="#language_file"><u>言語ファイル</u></a>内で探し出され、そのファイル内で見つかった対応する値によって置き換えられます。<br>
すべての翻訳値（アプリケーション翻訳、通知、E-mail）は、「変数」を含むことがあります。
変数は、#member#, #title#, #amount#のように、常に2つの#記号によって囲まれています。
変数は、Cyclos内で表示される際に、正しい値で置き換えられます。
変数名は一目瞭然で、すべての可能な値が標準の翻訳値の中ですべて使われています。
<hr class='help'>

</span>

</div> <%--  page-break end --%>