<div style="page-break-after: always;"
<a name="top"></a>
<br><br>オペレータ機能は、メンバーがオペレータを定められるようにします。
オペレータは、Cyclos内でそのメンバーのために一部のタスクを行うことを許された、ある種の下位レベルのメンバーです。
オペレータは自身の口座を持たず、彼らがいくらかのオペレーションを行えるメンバー口座にアクセスできるだけです。
従業員が3人の小さな会社を考えると、各従業員はその会社の口座のためのオペレータになります。<br>
メンバーと同様に、オペレータはグループに組織化されます。
各メンバーは、それ自身のオペレータグループを定めてもよいですし、それにより、メンバーは様々な許可を持つ様々なレベルのオペレータを作成することができます。
あなたは、例えば、支払いを行うことを許された1人の上位オペレータと、広告のみを管理できる数人のただのオペレータを作成できます。
オペレータによって行われるすべての支払いは、「実行者」という追加的なフィールドを持ち、メンバーはオペレータによって支払いを検索できます。
<span class="member notOperator"> 
<i>どこで見つけられる？</i><br>
オペレータの機能には、メイン「メニュー: オペレータ」を通じてたどり着けます。
このメインメニューセクションの下には、オペレータ機能にアクセスできるいくつかのサブメニューがあります:
<ul>
	<li><b>オペレータ:</b> オペレータの検索ウィンドウに移動します。
	ここで新しいオペレータを作成することもできます。
	<li><b>接続中のオペレータ:</b> どのオペレータが接続されているかを表示します。
	<li><b>オペレータグループ:</b> 様々なレベルのオペレータを定められます。
	<li><b>カスタムフィールド:</b> オペレータのための特別なフィールドを作成できます。
</ul>
</span>
オペレータは、特別なログインページを通じてログインできます。そのログインページには、「オペレータとしてログインする」というリンクを通じ、通常のログインページを通じてたどり着けます。
（このリンクが表示されるようにするためには、システム設定内で、オペレータモジュールが有効化される必要があります。）<br>
オペレータに、POSwebモジュールへのアクセスを与えることもできます（POSwebについての情報は、
チャネル<a
	href="${pagePrefix}payments#accesing_channels"><u>ヘルプページ</u></a>にて見つけられます）。


<br>
<span class="member"> オペレータは、特別なオペレータ用メインメニュー項目から、メンバーに関するアクションを実行できます。
その項目は、オペレータだけに見えるもので、「メンバーオペレーション」と呼ばれます。
これにより、オペレータは、通常、メンバーであれば「メインメニュー: パーソナル」項目の下に収まるであろうすべての機能にアクセスできます。</span>
<br><br>
<span class="admin">
<i>どうやってそれを動かす？</i><br>
オペレータは、まず、グループの<a
	href="${pagePrefix}groups#manage_group_permissions_member"><u>許可</u></a>、「オペレータ」ブロック、「オペレータを管理する」という表題のチェックボックスを通じて有効化されなければなりません。<br>
許可の設定に加え、オペレータがログインできるようにするためには、「オペレータログインを可能にする」チェックボックスを通じて、<a href="${pagePrefix}settings#access"><u>
アクセス設定</u></a> 内で有効化されていることを確認して下さい。
<br><br><b>注:</b> ログインページをカスタマイズするならば、オペレータのログインを可能にするために使われるコードを確実に維持するようにして下さい。
さもないと、オペレータログインリンクが見えなくなるかもしれません。
<br><br><b>注2:</b>
オペレータモジュールとオペレーションは、完全にメンバーの責任です。
管理者がメンバーのためにオペレータを管理することはできません。
管理者が行える唯一の管理は、<a
	href="${pagePrefix}user_management#connected_users_result"><u>接続中のユーザー</u></a>ページからオペレータを切断することです。
</span>
<hr>

<span class="member notOperator">
<a name="search_operator"></a>
<h3>オペレータ検索</h3>
このページでは、オペレータ（あなたが登録した）を検索できます。
その機能は、一般のメンバー検索機能と同じように機能します。
グループ選択ボックス内では、「すべてのグループ」フィルタを残すか、検索したい1つまたは複数のグループを選択できます。<br>
あなたの検索の結果を表示するには、「検索」をクリックして下さい。
<br><br>新しいオペレータを作成することもできます。これはこのウィンドウの下のドロップダウンボックス（「新しいオペレータを作成する」）内でオペレータグループを選択することによって行われます。
このドロップダウンボックスは、検索結果ウィンドウが1つもない場合にのみ見えます。
<hr class='help'>
</span>

<span class="member notOperator"> <a name="search_operator_result"></a>
<h3>オペレータ検索結果</h3>
このページは、オペレータ検索に対する結果リストを表示します。
オペレータの名前またはログイン名をクリックすると、プロフィールページが開きます。
<hr class="help">
</span>

<span class="member notOperator"> <A NAME="create_operator"></A>
<h3>オペレータを作成する</h3>
このページでは、新しいオペレータを作成できます。
赤いアスタリスク(*)の印が付いたフィールドは、すべて必須です。<br>
フィールドに記入した後、あなたは、直接そのプロフィールに行くか（「保存してオペレータのプロフィールを開く」ボタン）、新しいオペレータを追加する（「保存して新しいオペレータを挿入する」ボタン）ことができます。
<hr class='help'>
</span>

<a name="operator_profile"></a>
<span class="member">
<h3>オペレータプロフィール</h3>
このウィンドウは、オペレータのプロフィールを表示します。
たいていのフィールドは変更できませんが、変更できるものもあります。
変更をするには「変更」ボタンをクリックし、変更を保存するには「送信」をクリックして下さい。</span>
<span class="member notOperator">
<br><br>あなたがこの画面をチェックしている瞬間に、まさにこのオペレータがログインしているならば、そのことが通知されます。
「最終ログイン」フィールドが、「ログイン中」と（赤字で）表示されます。
<hr class='help'>
</span>

<span class="member notOperator">
<A NAME="actions_for_operator_by_member"></A>
<h3>オペレータのためのアクション</h3>
ここでは、このオペレータに関していくつかのアクションを実行できます。
このヘルプは、すべてのアクションの要約を与えます。
アクションについてのもっと詳細な説明については、具体的なアクション内のヘルプを参照できます。
<br><br>以下のアクションが利用可能です:
<UL>
	<LI><b>許可グループを変更する:</b> このオペレータが属するオペレータグループを変更します。
	<LI><b>E-mailを送信する:</b> オペレータにE-mailを送信します。これは、あなたのローカルなE-mailプログラムを開きます。
	<LI><b>ログインパスワードを管理する:</b> オペレータのためのパスワードを変更します。
	<li><b>ユーザーが現在ログインするのを許可する:</b>これは、オペレータが誤ったパスワードでのログインを数回試み、そのために彼のアカウントが一時的にブロックされた場合にのみ見えます。
	通常、許される試行の最大数があります。誤ったパスワードで、それよりも頻繁にログインしようと試みると、あなたのアカウントは、管理者によって設定された期間、一時的にブロックされます。
	もし、あなたがこのオペレータが彼自身が主張する者であると確信しているならば、このボタンをクリックすることにより、直ちに彼が再びログイン可能なようにすることができます。
	その場合、そのオペレータは、このための通常の待ち時間が過ぎるまで待つ必要がありません。
	<li><b>ログイン中のユーザーを切断する:</b> これは、オペレータが、まさにこの瞬間にログイン中の場合にのみ見えます。
	これは、上のプロフィールウィンドウ内の「最終ログイン」フィールドによっても示されます。それは「ログイン中」という言葉を表示します。
	この場合、あなたは、このボタンをクリックすることにより、そのオペレータを直ちにプログラムから締め出すことができます。
	あなたは、例えば、不正利用に関する保留中の調査がある時、または、オペレータが既にログインしているとシステムに思われログインできない時に、これを行いたいかもしれません。
</UL>
<hr class='help'>
</span>

<span class="member notOperator">
<A NAME="manage_operator_groups"></A>
<h3>オペレータグループを管理する</h3>
このページは、
<a href="#top"><u>オペレータ</u></a>グループのリストを示します。
ここで、あなたは以下のアクションを行えます:
<ul>
	<li><img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;
	編集アイコンを押すと、このグループのための設定のページに移動します。
	<li><img border="0" src="${images}/permissions.gif" width="16" height="16">&nbsp;
	許可アイコンを押すと、このグループのための許可を設定できるページに移動します。
	そのグループが「削除済み」状態の場合、このアイコンは、無効化されます（グレイアウトされます<img
		border="0" src="${images}/permissions_gray.gif" width="16" height="16">&nbsp;）。
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">&nbsp;
	消去アイコンをクリックすると、そのグループを削除します。
	その中に1人もメンバー（オペレータ）がいない場合に限り、グループを消去できます。
	<li><b>追加:</b> 新しいオペレータグループを追加するには、「新しいグループを挿入する」というラベルの付いた送信ボタンをクリックしなければなりません。
</ul>
<hr class='help'>
</span>

<span class="member notOperator">
<A NAME="manage_group_permissions_basic"></A>
<h3>基本的なグループ許可</h3>
このウィンドウでは、基本的な許可を設定できます。
基本的な許可は、他の機能には影響しません。例えば、オペレータがログインできない場合でも、彼は依然として支払いを受け取ることができるかもしれません。
以下の許可を設定できます:
<ul>
	<li><b>ログイン: </b><br>
	これがチェックされていない場合、このグループのオペレータはログインできません。
	<li><b>招待メッセージ: </b><br>
	これがチェックされている場合、このグループのメンバーは、彼らのメインページ内（ログイン後）でウィンドウボックスが見えます。それによって、彼らは、友人を招待し、あなたの組織を試してもらうことができます。
</ul>
<hr class='help'>
</span>

<span class="member notOperator"> <A
	NAME="manage_operator_group_permissions"></A>
<h3>オペレータグループ許可を管理する</h3>
このウィンドウでは、<a href="#top"><u>オペレータ</u></a>グループのための<a href="${pagePrefix}groups#permissions"><u>
許可</u></a>を設定できます。
これらの許可は、あなた自身のグループの許可に由来します。
つまり、オペレータは、あなた自身が許されている以上のことは決してできません。
オペレータは、それと同等かそれ未満のことしかできないのです。<br>
このため、あなたは恐らく、このヘルプ概観にリストで示されたオプションのすべてを見ることができません。
項目についてのさらなる情報を得るには、リンクを使ってください。
<br><br>このグループに属するオペレータは、これらの許可を受けるかもしれません（システム設定とあなた自身の許可に依ります）:
<br><br>
<b>メンバー口座</b>

<ul>
	<li><b>認可された支払いを見る</b>
	<li><b>スケジュールされた支払いを見る</b>
	<li><b>口座情報を見る:</b>
	ドロップダウンボックスを使って、オペレータが情報（支払、残高など）を見られる口座を選択してください。
</ul>
<b>広告</b>
<ul>
	<li><b>掲載する</b> 「掲載する」が選択された場合、オペレータは広告を掲載することができ、メニュー項目「パーソナル - 広告」がオペレータメニュー内に表示されます。
</ul>
<b>コンタクトリスト</b>
<ul>
	<li><b>管理する:</b> オペレータが<a
		href="${pagePrefix}user_management#contacts"><u>コンタクトリスト</u></a>を管理する、つまり、リストのメンバーを追加、編集、消去するのを可能にします。
	<li><b>見る:</b> オペレータがコンタクトを見る（そして、使う）ことだけを可能にしますが、それを変更する許可はありません。
</ul>
<b>保証書</b><br>
これはCyclosの保証システムの一部です。そこでは、Cyclos内の各口座残高が、裏付けされた貨幣総額によって保証されています。
あなたは以下の許可を選べます:
<ul>
	<li><b>支払債券付きで販売する:</b> 
</ul>

<b>請求書</b> <br>
このセクションでは、オペレータが他のメンバーに対して<a
	href="${pagePrefix}invoices"><u>請求書</u></a>を送信（ユーザープロフィールからか「口座」メニューから直接）できるかどうかを定められます。
	「システム請求書」が選択された場合、オペレータは「口座メニュー」からシステム口座に請求書を送信できます。
<ul>
	<li><b>メニューからのメンバー請求書オプション:</b> メニューからメンバーへの請求書オプションを表示します。
	<li><b>メンバーに送信する:</b> 他のメンバーへの請求書の送信を可能にします。
	<li><b>システムに送信する:</b> システム口座への請求書の送信を可能にします。
	<li><b>見る:</b> 請求書を見る。
</ul>

<li><b>ローン:</b> このセクションでは、オペレータのための<a
	href="${pagePrefix}loans"><u>ローン</u></a>についての許可を定められます。<ul>
	<li><b>見る:</b> 「見る」オプションが選択された場合、そのグループのオペレータはそのローンを見ることができます。見るが選択されていない場合、そのメニュー項目は表示されません。
	<li><b>返済する:</b> オペレータがローン返済を行えるようにするには、これを選択してください。
</ul>

<li><b>メッセージ:</b> このセクションでは、オペレータがCyclosの<a href="${pagePrefix}messages"><u>メッセージ</u></a>システムをどの範囲まで使って良いかを定められます。
<ul>
	<li><b>見る:</b> オペレータがメッセージシステムを見ることができます。
	<li><b>メンバーに送信する:</b> オペレータが他のメンバーにメッセージを送信することが可能です。
	<li><b>管理者に送信する:</b> オペレータが管理者にメッセージを送信することが可能です。
	<li><b>管理する:</b> オペレータがメッセージを移動および消去できます。
</ul>


<b>支払い:</b> ここでは、このオペレータグループについて、どのタイプの支払いが可能であるかを指定できます。
たいてい、あなたは1つのみ、または2,3のタイプを選択するでしょう。
<ul>
	<li><b>自己支払い:</b> これが選択された場合、オペレータはあなた自身の口座間で支払いを行えます。
	ドロップダウン内で、可能な取引タイプを指定できます。
	このオプションは、あなたが複数のオペレータ口座を持っている場合にのみ意味をなします。
	<li><b>メンバー支払い:</b> 選択された場合、オペレータは別のメンバーに支払いを行えます。
	<li><b>メニューからのメンバー支払いオプション:</b> このオプションがチェックされている場合、オペレータは「口座」メニューから他のメンバーに直接支払いを行えます。
	<li><b>システム支払い:</b> 選択された場合、オペレータはシステム口座に対して支払いを行えます。
	このオプションが選択されていない場合、メニュー項目「システム支払い」は表示されません。
	<li><b>POSweb支払いをする:</b> オペレータがPOSweb(Point of Sale)ページで支払いを行えるようにします。
	<li><b>POSweb支払いを受け取る:</b> オペレータがWEBposを通じて支払いを受け取れるようにしたい場合は、このオプションを選んでください。
	これは典型的に店舗における状況でしょう。カウンターにいる店員は、オペレータとして（通常、http://..cyclos/poswebを通じて)POSwebインタフェースにログインし、続くウィンドウ内で、顧客がその店舗に支払いをするために彼のPINを入力できます。<br>
	このチェックボックスをチェックすると、この手続きが可能になります。（通常は、それからそのオペレータのための他のすべての許可を無効にするでしょう。）
	<li><b>認可または拒否する:</b> あなたが受取人の場合、オペレータが支払いを認可または拒否できるようにします。
	<li><b>支払い認可をキャンセルする:</b> 認可された支払いが使われる場合、これはオペレータが彼らの認可された支払い（一度作成されたが未だ認可されていないもの）をキャンセルできるようにします。
	<li><b>スケジュールされた支払いをキャンセルする:</b> スケジュールされた支払いが使われる場合、これは計画された日付が始まる前に、オペレータが彼らのスケジュールされた支払いをキャンセルできるようにします。
	<li><b>スケジュールされた支払いをブロックする:</b> オペレータが、彼のスケジュールされた支払いを一時的にブロックできるようにします。
	<li><b>他のチャネルからの支払いをリクエストする:</b> これがチェックされた場合、オペレータは他のチャネルを通じて、支払いリクエスト（外部請求書）を送信できます。ドロップダウンボックスからそれらのチャネルを選べます。
</ul>

<b>照会状</b> <br>
これにより、オペレータは<a
	href="${pagePrefix}references"><u>照会状</u></a>を閲覧または管理できます。
<ul>
	<li><b>閲覧する:</b> 照会状を閲覧する
	<li><b>自分の照会状を管理する:</b> オペレータが、他のメンバーに照会状を与える許可を含み、照会状システムを使えるようにします。
	<li><b>自分の取引フィードバックを管理する:</b> オペレータが、取引関するフィードバックを与える許可も含め、あなたの<a href="${pagePrefix}transaction_feedback#feedbacks_summary"><u>取引フィードバック</u></a>を管理できるようにします。
</ul>

<b>レポート</b><br>
「自分のレポートを見る」が選択された場合、オペレータは、あなた自身の<a href="${pagePrefix}reports#member_activities"><u>レポートページ</u></a>を見ることができます。
</ul>
<hr class='help'>
</span>

<span class="member notOperator"> <a name="edit_operator_group"></a>
<h3>オペレータグループを修正する</h3>
<a href="#top"><u>オペレータ</u></a>グループ設定は、2つの部分に分けられます:
<ul>
	<li><b>グループ詳細:</b> ここでは、オペレータグループの名称と説明のみを変更できます。
	<li><b>支払いタイプごとの1日ごとの最大額:</b> これらの設定により、支払いタイプごとの1日ごとの最大額を定められます。
	すべての利用可能な支払いタイプがここにリストで示されます。各々のタイプについて、オペレータがこの支払いタイプで支払える額の制限の有無を指定できます。
</ul>
あなたは、「グループ許可」をクリックすることにより、このグループの許可に直接行くことができます。
<hr class='help'>
</span>

<span class="member notOperator">
<A NAME="insert_operator_group"></A>
<h3>新しいオペレータグループを挿入する</h3>
このウィンドウにより、新しい<a href="#top"><u>オペレータ</u></a>グループを作成できます。
<br>
以下のオプションがあります
<ul>
	<li><b>削除済み:</b> もし削除済みグループを作成するならば、それはこのグループに入れられるオペレータが本当にシステムを去ったということを意味します。
	いったん削除済みグループに入れると、任意の他のグループに戻すことができません。
	そのデータは、依然としてデータベース内にあり、あなたはそれを閲覧できますが、それはバックアップ機能としてのみ役立ちます。
	<li><b>名称:</b> グループの名称。
	<li><b>説明:</b> グループの説明。
	<li><b>次から設定をコピー:</b> これは、定められた別のオペレータグループが既にある場合にのみ見えます。
	あなたはここで別のオペレータグループを指定でき、すると、新たに作成されるグループのための設定は、あなたが指定したグループからコピーされます。
</ul>
新しいグループを作成した後、次の画面でグループ特性を設定し、そのグループの許可も設定して下さい。
<hr class='help'>
</span>

<span class="member notOperator">
<a name="manage_group_customized_files"></a>
<h3>カスタマイズされたPOSweb</h3>
あなたは、POSwebのためのヘッダーとフッターを定められます。
このウィンドウは、このグループのためのカスタマイゼーションのリストを示します。
以下のオプションがあります:
<ul>
	<li><b>修正する</b> <img border="0"
		src="${images}/edit.gif" width="16" height="16">&nbsp;編集アイコンを通じてカスタマイズされた既存のファイル。
	<li><b>見る</b> グループのメンバーにとって、
	<img border="0" src="${images}/view.gif" width="16" height="16">&nbsp;ビューアイコンを通じて、結果がどのように見えるか。
	<li><b>消去</b> <img border="0"
		src="${images}/delete.gif" width="16" height="16">&nbsp;消去アイコンを通じて、カスタマイズされたファイル定義。
	<li><b>挿入</b> 「新しいファイルをカスタマイズする」ボタンを通じてカスタマイズされた新しいファイル。
</ul>
<hr class="help">
</span>


<span class="member notOperator"> <a name="customize_group_file"></a>
<h3>POSwebのヘッダーとフッターを修正する</h3>
このページでは、POSWebページのヘッダーとフッターをカスタマイズできます。
このページは、オペレータが支払いを行ったり受け取ったりするためにアクセスできます。（POSwebのURLは、たいてい、www.domain.com/cyclos/poswebのような何かです。)<br>
オペレータがログインした後、ヘッダーとフッターは支払いウィンドウの上下に表示されます。
<hr class="help">
</span>


<span class="member notOperator">
<A NAME="change_group_operator"></A>
<h3>オペレータグループを変更する</h3>
このウィンドウでは、別のグループに
<a href="#top"><u>オペレータ</u></a>
を移すことができます。
これは、そのオペレータが他のグループを許可を受け取ることを意味します。
フォームに記入した後、あなたの変更を保存および確約するには、「グループを変更する」ボタンをクリックして下さい。
<br>
<br><br>「永久的に削除する」オプションをクリックすると、オペレータが削除されます。
これは、そのオペレータが未だどのような取引も行っていなかった場合にのみ可能です。<br>
そうでない場合は、それを「削除済み」グループへと移動しなければなりません。これは、そのオペレータがいかなる追加のアクションも（ログインさえも）行えなくなることを意味しますが、あなたは依然として過去における彼のアクションを閲覧できます。
<hr class='help'>
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