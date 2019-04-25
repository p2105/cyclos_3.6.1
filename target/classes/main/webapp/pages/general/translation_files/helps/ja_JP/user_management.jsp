<div style="page-break-after: always;"
<span class="admin">
<br><br>
これらのページは、ユーザー管理機能です。
それらは、メンバーの検索、新しいメンバーの登録、現在ログイン中のユーザーの概観、あるいは、メンバー状態についての他の情報の閲覧のために使えます。

<i>どこで見つけられる？</i><br> 
以下は、利用可能な機能とそれを見つけられる場所のリストです:
<ul>
	<li><b>メンバーの検索および作成:</b> 「メニュー: ユーザーとグループ > メンバーの管理」を通じて行えます。
	これは仲介者の検索を含みます。
	<li><b>管理者の検索および作成:</b> 「メニュー: ユーザーとグループ > 管理者の管理」を通じて行えます。
	<li><b><a href="#connected"><u>接続中のユーザー</u></a>:</b> 「メニュー: ユーザーとグループ > 接続中のユーザー」を通じて見つけられます。
	<li><b><a href="#bulk_actions"><u>バルクアクション</u></a>:</b> 「メニュー: ユーザーとグループ > バルクアクション」を通じて見つけられます。
</ul>
</span>


<span class="broker">
<ul>
	<li><b>メンバーの作成／登録:</b> あなたがこのための許可を持っているならば、これは「メニュー: 仲介 > メンバーの登録」を通じて見つけられます。
</ul>
</span>

<span class="member">
<ul>
	<li><b>メンバーの検索:</b> あなたは「メニュー: 検索 > メンバー」を通じてメンバーを検索できます。
</ul>
</span>
<hr>

<span class="admin">
<A NAME="create_user"></A>
<h3>ユーザーを作成する</h3>
ここでは、新しいメンバーについての情報を入力できます。
そのウィンドウは非常に分かり易いものです。このフォーム内のフィールドは、あなたの設定に依ります。<br>
そのメンバーは、最初のフィールドに挙げられている<a href="${pagePrefix}groups"><u>グループ</u></a>の一員になります。
<br><br>
あなたが作成しているメンバーのグループに対して仲介者許可を持つ仲介者グループが存在する場合、
あなたは（オプションとして）そのメンバーをその仲介者グループの仲介者に割り当てられます。
このためには、一番下の「仲介者を割り当てる」というラベルの付いたチェックボックスをチェックして下さい。<br>
あなたは、そのユーザーのためのパスワードを指定でき、そのユーザーがそのパスワードを直接使用できるか、
それとも、次回ログイン時にそれを変更しなければならないかを指定できます。
<br><br>データを記入した後、そのメンバーを保存して新しいメンバーを入力する（ボタン「保存して新しいメンバーを挿入する」）か、新しいメンバーの<a href="${pagePrefix}profiles"><u>プロフィル</u></a>を直接開く（ボタン「プロフィールを保存して開く」）ことができます。
<hr class="help">
</span>

<span class="broker"> <a name="create_user_for_broker"></a>
<h3>仲介 - 新しいメンバーを作成する</h3>
ここでは、新しいメンバーについての情報を入力できます。
そのウィンドウは非常に分かり易いものです。このフォーム内のフィールドは、システム設定に依ります。<br>
登録を完了した後、そのメンバーは、あなたの仲介されるメンバーの1人として自動的に割り当てられます。<br>
あなたは、そのユーザーのためのパスワードを指定でき、そのユーザーがそのパスワードを直接使用できるか、
それとも、次回ログイン時にそれを変更しなければならないかを指定できます。
<br><br>データを記入した後、メンバーを保存して、新しいメンバーを入力する（ボタン「保存して新しいメンバーを挿入する」）か、新しいメンバーの<a href="${pagePrefix}profiles"><u>プロフィール</u></a>を直接開く（ボタン「プロフィールを保存して開く」）ことができます。
<br><br>新しいメンバーの登録に対して、あなたは自動的な<a href="${pagePrefix}brokering#commission"><u>委託手数料</u></a>を受け取るかもしれません。（あなたのシステム内のルールに依ります。）
委託手数料は、あなたが登録したメンバーのトレード量に依ります。<br>
「メニュー: 仲介 > メンバー」を通じて、あなたが登録したメンバーを管理し、彼らがどうしているかを辿ることができます。
<hr class="help">
</span>


<span class="member">
<A NAME="search_member_by_member"></A>
<h3>メンバーを検索する</h3>
このページではメンバーを検索できます。
メンバー検索は、すべてのメンバープロフィールフィールドを検索します。
あなたは検索内で複数のキーワードを使えます。<br>
様々な「オペレータ」は、メンバー（および広告）検索で使えます。
最も一般に使われるのは以下のものです:
<ul>
	<li><b>*</b> アスタリスク「ワイルドカード」により、言葉の一部分を検索できます。
	例えば、ba*での検索は、彼らのプロフィールの中にBaという文字の組み合わせを持つすべてのユーザーを返します。
	例えば、Barbara, Bart, Baker streetなどです。（ここでは、後者は住所フィールドでしょう。）
	<li><b>- not</b> 前にマイナス記号か「not」がついたキーワードとスペースを用いた検索は、そのキーワードを含まない結果を返します。
	<li><b>or</b> その検索は、「or」の前の言葉かその後ろのキーワードを持つ結果を返します。
	<li><b>and</b> その検索は、「and」の前の言葉とその後ろのキーワードの両方を持つ結果を返します。
</ul>

<hr class="help">
</span>

<span class="member"> 
<A NAME="search_member_result"></A>
<h3>検索結果（メンバー検索についての）</h3>
このウィンドウは、メンバー検索の結果を表示します。
「ログイン名」または「メンバー名」を選択すると、そのメンバーの<a href="${pagePrefix}profiles"><u>
プロフィール</u></a>が開かれます。
画像アイコンを選択すると、ポップアップウィンドウ内に画像が開かれます。
<hr class="help">
</span>

<span class="admin"> 
<A NAME="search_member_by_admin"></A>
<h3>メンバーを検索する</h3>
メンバー検索ページ（メニュー: ユーザーとグループ > メンバーの管理）では、メンバーの検索と新しいメンバーの登録ができます。
<br><br>メンバーを検索したい場合は、様々な検索フィールドに記入できます。（ただし、それらのいずれも必須ではありません。）
フィールドに何も入力せずに、ただ「検索」ボタンをクリックすると、すべてのメンバーのリストが得られます。<br>
<ul>
	<li><b>グループフィルタ:</b> ここでは、<a href="${pagePrefix}groups#group_filters"><u>
	グループフィルタ</u></a >を指定できます。
	<li><b><a href="${pagePrefix}groups"><u>許可グループ</u></a></b>
	<li><b>仲介者ログイン名／仲介者:</b> ここに仲介者のログイン名または実名を入力して下さい。すると、あなたの結果ページは、この仲介者に属しているメンバーを表示します。
	<li><b>アクティベーション起点／終点:</b> これらの日付フィールドにより、誰かがあなたの組織のメンバーになった日付について検索できます。
カレンダーアイコン（<img border="0" src="${images}/calendar.gif" width="16" height="16">&nbsp;）をクリックして、日付選択機能を使っても良いでしょう。
</ul>
<br><br>
新しいメンバーを登録するためには、そのフォームの一番下、左側にあるドロップダウンを使わなければなりません。
ここで、メンバーを作成したいグループを選択して下さい。すると、<a href="#create_user"><u>登録フォーム</u></a>に移動します。
<hr class="help">
</span>
 
<span class="admin">
<A NAME="admin_search_member_result"></A>
<h3>検索結果（メンバー検索についての）</h3>
このウィンドウは、メンバー検索の結果を表示します。
ログイン名またはメンバー名を選択すると、そのメンバーの<a href="${pagePrefix}profiles"><u>プロフィール</u></a>が開かれます。
そのプロフィールページ内の戻るボタンを選択すると、検索結果に戻ります。
<br><br>ウィンドウ内の右上、ヘルプアイコンの隣にある印刷アイコン（<img border="0" src="${images}/print.gif" width="16" height="16">&nbsp;）をクリックすることにより、検索結果を印刷することもできます。
これにより、ボタンをクリックして概観を印刷できる、プリンタに適したウィンドウに移動します。
<br><br>それとは別に、保存アイコン（<img border="0" src="${images}/save.gif" width="16" height="16">&nbsp;）をクリックすることにより、結果をファイルにダウンロードすることも可能です。
その結果は、<a href="${pagePrefix}loans#csv"><u>CSVフォーマット</u></a>でダウンロードされます。それは、メンバーの<a
	href="${pagePrefix}profiles"><u>プロフィール</u></a>内に存在するすべてのフィールドを含みます。（したがって、この結果ウィンドウ内には見えない多くのフィールドも含んでいます。）<br>
<a href="${pagePrefix}settings#local"><u>ローカル設定</u></a>では、列の見出し（最初の行）内にフィールド名を表示したいかどうかを指定できます。
<br><br>注: レポート機能では、もっと具体的な<a href="${pagePrefix}reports#member_lists"><u>メンバーリスト</u></a>を得ることができます。
例えば、口座残高や広告数のような追加的なデータの付いたメンバーリストが、レポート機能で見つけられます。
<hr class="help">
</span>


<span class="broker admin"> <a name="search_pending_member"></a>
<h3>保留中メンバーを検索する</h3>
保留中のメンバーは、登録されたが、E-mailメッセージに返答することにより、彼らの登録を確認していないメンバーです。
確認後にのみ、そのメンバーはログインできます。<br>
特定の時間の後、保留中のメンバーはシステム（とリスト）から自動的に削除されます。
3つの登録オプションすべて（一般登録ページでの自己登録、仲介者による登録、メンバーによる登録）は、E-mail確認を要求し得ます。<br>
注: メンバーは既にそのシステム内に存在する（他の保留中メンバーかアクティブなメンバーの）
E-mailアドレスでは登録できません。
<br><br>このページでは、保留中のメンバーを検索できます。
あなたは、名前、グループ、登録日の範囲によって検索できます。<br>
グループ検索は、メンバーがそのグループに属することを意味せず、
それはE-mail確認の後にそのメンバーが一員となる予定のグループを示します。<br>
</span>
<span class="admin"> あなたは、仲介者によっても検索できます。
これは、その検索が、選択された仲介者によって登録されたメンバーだけを表示することを意味します。
これは、仲介者によって登録されたメンバーが、確認を必要とする場合にのみ機能します。
これは、任意の<a href="${pagePrefix}groups#group_registration_settings"><u>グループ設定</u></a>です。
最大登録期間は、ローカル設定で定められます。<br>
<br>
<hr class="help">
</span>

<span class="broker admin"> <a name="search_pending_member_result"></a>
<h3>保留中メンバーのリスト</h3>
このウィンドウは、メンバー検索の結果を表示します。
これらのメンバーは、「アクティブ」なメンバーでないということに注意して下さい。
（彼らはシステム内でログインできず見えません。）
稀な場合にのみ、あなたはそのリストからメンバーを消去したいでしょう。
保留中メンバーの消去は、そのメンバーが彼／彼女の登録を確認できないことを意味します。<br>
あなたがそのメンバーを編集すると、あなたはプロフィールデータを閲覧および修正でき、
必要ならば、確認を再び送信できます。
<hr class="help">
</span>

<span class="broker admin"> <a name="pending_member"></a>
<h3>保留中メンバーの詳細</h3>
このページで、あなたはプロフィールデータを閲覧および修正でき、必要な場合は、確認E-mailを再び送信できます。
<hr class="help">
</span>

<span class="admin">
<a name="search_admin"></a>
<h3>管理者を検索する</h3>
管理者検索ページ（メニュー: ユーザーとグループ > 管理者の管理）では、管理者の検索と新しい管理者の登録ができます。
<br><br>そのフォームは非常に単純です: あなたは単にキーワードを指定するか、検索を特定の管理者グループに制限するか、その両方を行うことができます。
フィールドに何も入力せずにただ「検索」ボタンをクリックすると、すべての管理者のリストが得られます。<br>
<br><br>新しい管理者を登録するためには、そのフォームの一番下にあるドロップダウンを使わなければなりません。
ここで、管理者を作成したい<a
	href="${pagePrefix}groups#admin_groups"><u>グループ</u></a>を選択して下さい。すると、新しい管理者のための<a href="#create_user"><u>登録フォーム</u></a>に移動します。
</span>

<span class="admin">
<a name="search_admin_result"></a>
<h3>検索結果（管理者検索）</h3>
このボックスは、あなたの管理者検索の結果を与えます。
管理者のログイン名か実名をクリックして、その管理者についての詳細を得られます。
<hr class="help">
</span>

<span class="admin">
<a name="create_admin"></a>
<h3>新しい管理者を登録する</h3>
ここでは新しい管理者を登録できます。
私たちは、別の人々が単一の管理者アカウントを共有しないように、管理者として働くすべての人々に彼ら自身の口座とログイン名を与えることを<b>強く</b>勧めます。
これにより、許可を維持し、あり得るエラーを追跡し、組織を去った人のアカウントを閉じることが容易になります。
<br><br>そのフォームは非常に単純で分かり易いものです。
赤いアスタリスク（*）の付いたフィールドは、いずれも必須です。
<br><br><br><br>データを記入した後、管理者を保存して新しい管理者を入力する（ボタン「保存して新しい管理者を挿入する」）か、直接、新しい管理者の<a href="${pagePrefix}profiles"><u>プロフィール</u></a>を開く（ボタン「保存してプロフィールを開く」）ことができます。
<hr class="help">
</span>

<span class="admin">
<a name="connected"></a>
<h2>接続中のユーザー</h2>
接続中ユーザーページ（メニュー: ユーザーとグループ > 接続中のユーザー）では、どのユーザー（メンバー、管理者、仲介者）が現在ログイン中でシステムを使っているかを概観できます。

<hr>
</span>

<span class="admin">
<A NAME="connected_users"></A>
<h3>接続中のユーザー</h3>
このウィンドウにより、あなたが下のウィンドウ内で、どの<a href="${pagePrefix}groups#group_categories"><u>
タイプ</u></a>の接続中ユーザーを見たいかを指定できます。
「表示する」ドロップダウンにより、
「管理者」、「仲介者」、「メンバー」、「
<a href="${pagePrefix}operators"><u>オペレータ</u></a>」から選べます。<br>
結果を表示するには「送信」をクリックして下さい。
<hr class="help">
</span>
 
<A NAME="connected_users_result"></A>
<span class="admin">
<h3>検索結果（接続中のユーザー）</h3>
この機能は、上のウィンドウでのあなたの選択に応じて、接続中のユーザーのリストを表示します。<br>
リスト内で、メンバーをクリックし、プロフィールを開くことができます。
許可のある管理者は、最後の列の消去アイコン（<img border="0"
	src="${images}/delete.gif" width="16" height="16">&nbsp;）をクリックすることにより、メンバーを切断できます。
</span>
<span class="member">
<h3>検索結果（接続中のオペレータ）</h3>
この機能は、接続中の<a href="${pagePrefix}operators"><u>
オペレータ</u></a>のリストを表示します。<br>
リスト内で、オペレータをクリックし、プロフィールを開くことができます。
あなたが許可を持っていれば、最後の列の消去アイコン（<img border="0" src="${images}/delete.gif" width="16" height="16">&nbsp;）をクリックすることにより、オペレータを切断できます。</span>

<span class="admin">
<a name="bulk_actions"></a>
<h2>バルクアクション</h2>
バルクアクション機能（メニュー: ユーザーとグループ > バルクアクション）により、管理者はユーザーのグループ分け全体に対するアクションを行えます。

<hr>
</span>

<span class="admin">
<A NAME="bulk_actions_filter"></A>
<h3>バルクアクションフィルタ</h3>
このウィンドウにより、管理者は
<a href="#bulk_actions"><u>バルクアクション</u></a>が行われるユーザーのグループを指定できます。
フィールドは、論理的なAND検索に結び付いているので、あまりにも多く指定しすぎないように注意して下さい。さもないと、空の結果に終わるかもしれないからです。
<ul>
	<li><b>グループ:</b> ここでは、<a href="${pagePrefix}groups#group_filters"><u>
	グループフィルタ</u></a>を指定します。
	<li><b>許可グループ:</b> ここでは、Here you specify the <a href="${pagePrefix}groups"><u>
	グループ</u></a>を指定します。これが上で指定されたグループフィルタと競合しないように気を付けて下さい。
	通例、あなたはグループフィルタかグループを指定しますが、両方は指定しないでしょう。
	<li><b>仲介者ログイン名／仲介者:</b> そのアクションが1仲介者のすべてのメンバーに対してなされるようにしたいならば、ここで、実名またはログイン名のいずれかによって仲介者を指定します。
	<li><b>...:</b> そのフォームの残りの部分は、あなたのメンバープロフィールについて定められた、いくつかの<a href="${pagePrefix}custom_fields"><u>
	カスタムフィールド</u></a>をリストで示します。
</ul>
一度、バルクアクションのためのあなたの基準を指定したならば、そのフォームの右下にある「プレビュー」ボタンをクリックすることにより、どのメンバーが含まれるかを見ることができます。
そうすると、含まれるメンバーのリストが提示されます。
<hr class="help">
</span>

<span class="admin"> <A NAME="bulk_action"></A>
<h3>アクション</h3>
ここでは、行われることになる<a href="#bulk_actions"><u>バルクアクション</u></a>が指定されます。
以下のことが可能です:
<ul>
	<li><b>グループを変更する:</b> これは、選択されたグループ分けの許可グループを変更します。<br>
	これを選択すると、あなたは新しい<a
		href="${pagePrefix}groups"><u>許可グループ</u></a>とコメントを入力するよう求められます。
	「送信」をクリックした後、関わるすべてのメンバーがその新しいグループへと移動されます。
	<li><b>仲介者を変更する:</b> これは、選択されたグループ分けの<a
		href="${pagePrefix}brokering"><u>仲介者</u></a>を変更します。<br>
	これを選択すると、あなたは新しい仲介者のログイン名または実名を与えるよう求められます（一方を入力すると、他方は自動補完されます）。<br>
	「委託手数料を一時停止する」チェックボックスにチェックすると、すべての実行中および未決済の<a href="${pagePrefix}brokering#commission"><u>委託手数料支払い</u></a>を放棄することになります。
	あなた、新たに割り当てられた仲介者が、前任の仲介者のアクションから生じた委託手数料支払いを受け取る権利を持たない場合に、このチェックボックスを使いたいかもしれません。<br>
	また、あなたは、コメントも入力すべきでしょう。「送信」ボタンをクリックした後、すべての関わるメンバーは割り当てられた仲介者を持ちます。
</ul>
<hr class="help">

<A NAME="import_members"></A>
<h3>メンバーをインポートする</h3>
この機能により、メンバー（プロフィール）をインポートすることが可能です。また、オプションとして、メンバーごとに初期クレジット設定させ、システム口座からの／への初期支払いを生成することもできます。
数字と日付は、ローカル設定の定義に応じたフォーマットにして下さい。<br>
フィールドは、列名によって特定されます。
列名は、大文字と小文字の区別がなく、最初の行にある必要があります。
列は、任意の順序にできます（列1や列2といったものはなく、名称が正しい限り、それは機能します）。
フィールドが任意である場合には、その列全体を省くか、あるいは、その列の値を空のままにすることができます。<br>
以下の列／フィールドがサポートされています。
<ul>
	<li>名前（必須）<br>
	メンバーのフルネーム。
	<li>ユーザー名（必須）<br>
	これはログイン名で一意的です。つまり、この名前のユーザーが既にシステム内に存在している場合には、エラーになります。
	ログイン名が自動生成される（口座）番号の場合、その列は必要なく、Cyclosがログイン名を生成します。
	<li>作成日（任意）<br>
	指定された場合、個人メンバーレポート内の日付（メンバー登録日）が、この日付に設定されます。
	その列で日付が設定されない場合、現在の（インポート）日付が設定されます。
	<li>パスワード（任意）<br>
	平文のメンバーパスワード。メンバーは、最初のログインの際に、それを変更しなければなりません。
	<li>E-mail（Cyclosの設定に応じて必須または任意）
	それは的確なE-mailアドレスでなければなりません。
	<li>残高（任意）<br>
	初期の口座残高。口座タイプが選択されている場合にのみ使われます。
	口座タイプを選択する場合、支払いタイプを指定できます（マイナスの残高についてはメンバーからシステム、プラスの残高についてはシステムからメンバー）。<br>
	このオプションを使う場合、あなたは引き落とされる口座に十分なクレジットがあることを確認しなければなりません。
	<li>クレジット制限（任意）<br>
	その口座の（マイナスの）クレジット制限。空の場合には、グループ口座設定から標準値を取ります。
	<li>クレジット上限（任意）<br>
	その口座のクレジット上限。空の場合には、グループ口座設定から標準値を取ります。
	<li>カスタムフィールド内部名（任意）<br>
	選択されたグループに関連したカスタムフィールドの内部名。
	
	The required
	validation is honored.
	フィールドがリスト（列挙型）の場合、メンバーのインポートはそれに既存の値がある場合にのみ成功します。
	例えば、カスタムフィールド「地域」があり、3つの可能な地域「中央」、「南」、「北」がある場合、他の地域のメンバーはインポートされません。
	地域が空であるメンバーはインポートされます。（ただし、フィールドが「必須」に設定されていない場合です。）
	<li>メンバー記録タイプ（任意）<br>
	メンバー記録タイプのための値です。
	標準データベースの例は「所見」で、そこではコメントは所見記録タイプのフィールドです。
	このフィールドは内部名（フィールド設定で指定された）でなければなりません。<br>
	記録タイプフィールドをインポートしたい場合は、この記録タイプのために定義されたすべてのフィールドがCSVファイル内で（列として）指定される必要があります。
	</ul>
<hr class="help">


<A NAME="imported_members_summary"></A>
<h3>インポートされたメンバーの概要</h3>
このページは、インポートされたメンバーの概観を与えます。
この段階では、未だ何も処理されていません。
あなたは、リンク（数字）を選択して、インポートが成功または失敗したメンバーの状態を見ることができます。（あるいは、「総メンバー」の後ろの数字を選択することにより、両方を見ることができます。）<br>
「インポート」を選択すると、成功したメンバーがインポートされます。
それでもなお、インポートされたメンバーの状態を閲覧するのは良いことです。
<hr class="help">


<A NAME="imported_member_details"></A>
<h3>インポートされたメンバーの検索</h3>
このウィンドウでは、インポートされたリスト内を特定のメンバーについて検索できます。
あなたは行番号またはメンバー名のいずれかによって検索できます。
メンバー名検索オプションは、ログイン名とメンバー名のフィールド内を検索します。<br>
<hr class="help">


<A NAME="imported_member_details_result"></A>
<h3>インポートされたメンバーの検索結果</h3>
このウィンドウは、インポートの結果を表示します。
インポートエラーの場合には、エラータイプを知らせ（例えば、フィールドがない、名前が既に使われているなど）、インポート成功の場合には、クレジット制限（下限）と口座残高を表示します。<br>
メンバーを処理するには、戻ると「インポート」ボタンを押して下さい。
</span>

<span class="member">
<hr>
<br><br><A NAME="contacts"></A>
<h3>コンタクト</h3>
<br><br>これらの画面では、あなたのコンタクトを管理できます。

コンタクトリスト（メニュー: パーソナル > コンタクト）では、マウスでリストから以下のうちの1つを選択することにより、様々なアクションを行えます:
<ul>
	<li><b>ログイン名 - メンバー名:</b> メンバーのプロフィールページを開きます。
	<li><b>E-mail:</b> このメンバーにE-mailを送信します。
	<li><b><img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;</b>
	このメンバーについての追加的な情報を閲覧／追加／編集します。
	<li><b><img border="0" src="${images}/edit_gray.gif" width="16"
		height="16">&nbsp;</b> アイコンに色がない場合、それはその情報フィールドが何も情報を含んでいないことを意味します。
	<li><b><img border="0" src="${images}/delete.gif" width="16"
		height="16">&nbsp;</b> あなたのコンタクトリストから、そのメンバーを消去します。
</ul>
初めのうちは、このリスト内には全くコンタクトがありません。
あなたは2つの方法でコンタクトを追加できます: 
<ul>
	<li>下の「<a href="#add_contact"><u>新しいコンタクトを追加する</u></a>」ウィンドウを使って下さい。
	<li>まず<a href="${pagePrefix}#search_member_by_member"><u>メンバーの検索</u></a>（「メニュー: 検索」）を行い、
	検索結果のリスト内で、メンバーの名前をクリックすることにより、そのメンバーの<a href="${pagePrefix}profiles"><u>プロフィール</u></a>に入れます。
	そのメンバーをあなたのコンタクトリストに追加するには、プロフィール内で、「コンタクトに追加する」をクリックして下さい。
</ul>
<hr class="help">

<br><br><A NAME="add_contact"></A>
<h3>コンタクトを追加する</h3>
ここでは、あなたのコンタクトリストに新しいコンタクトを追加できます。
あなたは、ログイン名または名前を（自動補完の）フィールドに入力して、「送信」をクリックすることによってこれを行えます。
<hr class="help">

<br><br><A NAME="contact_note"></A>
<h3>コンタクトの注釈</h3>
このページでは、ユーザーについての追加的な情報を挿入できます。
この情報は、あなただけに見え、あなたがそのメンバーをあなたのコンタクトリストから除くと消去されます。
<hr class="help">

<a name="contact_us"></a>
<h3>連絡先</h3>
このページは、あなたがこのソフトウェアについて質問がある場合の連絡先アドレスを含みます。
<hr class="help">
</span>

</div> <%--  page-break end --%>

<br><br>


