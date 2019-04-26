<div style="page-break-after: always;"
<br><br>簿記機能は、銀行口座のような「外部口座」か他の通貨システムからの口座を
Cyclosシステム内の口座とリンク（ミラー）するために使えます。
<br><br>簿記機能は、外部口座（とその取引）の完全なミラーをCyclos内にローカルに持つことを可能とするので、
Cyclos取引をインポートされた取引と管理上「リンク」することが可能です。
これは、両方の取引が互いを参照し、追加的な状態を受け取ることを意味します。
この状態は、取引概要ウィンドウ内に特定のアイコンとして現れます。
状態ごとの取引リストの結果を検索および印刷することも可能です。
<br><br>
簿記モジュールの典型的な使用法は、内部（Cyclos）ユニットが銀行口座にある伝統的な貨幣で裏付けらているシステムの残高を制御することです。
そのような場合、銀行口座内の取引は、Cyclos内の特定のユニット取引と直接的な関係を持っています。
例えば、銀行にある預金（入ってきた支払い）は、Cyclosユニットの「購入」になり得るシステムからメンバーへの支払いか、
Cyclos内のローンの返済に関連付けることができます。
そして、逆に、銀行口座（デビット）からメンバーの銀行口座への支払いは、
Cyclos内のメンバーからシステムへの（例えば、両替）支払いに関連付けることができます。
調停機能は、Cyclosユニットの「裏付け」を制御するのに役立ちます。
例えば、内部ユニットが伝統的通貨によって100%裏付けられているシステムの「調停残高」は、1対1になります。
<br><br>インポートされた取引に関して、特定のタイプの（Cyclos）取引を自動的に生成することが可能です。
例えば、外部の銀行口座に入ってきた支払いは、Cyclosのシステムからメンバーへの支払いを生成できます。<br>
これは簿記モジュールのインポート設定セクションで詳細に説明されています。
<br><br>「裏付け」の聖書は、簿記モジュールの使用法の単なる1例です。
そのモジュールは、外部取引がローカルシステム内のローカルな取引またはローン状態変更を生成する必要がある他の場合のために実行され得ます。

<i>どこで見つけられる？</i>
<br>
簿記モジュールは、「メニュー: 簿記」で見つけられます（このメニュー項目が現れるようにするには、
管理者グループに対して許可が設定される必要があります）。

<br><br><i>どうやって動かす？</i><br>
そのモジュールが見えるようにするには、あなたはブロック「外部口座（簿記）」内で、
正しい<a
	href="${pagePrefix}groups#manage_group_permissions_admin_system"><u>管理者許可</u></a>
が必要です。
<br><br>Cyclos内に新しい外部取引をインポートできるようになる前に、あなたは以下のステップを行わなければなりません:
<ol>
	<li>これらの取引のためにあなたが必要とする<a
		href="${pagePrefix}account_management#transaction_types"><u>
	取引タイプ</u></a>が存在していることを確認して下さい。
	<li>「メニュー: 外部口座を管理する > 新しい外部口座」を通じて外部口座を作成して下さい。
	<li><b>ファイルマッピング:</b> あなたが外部口座を作成したウィンドウの下のウィンドウを通じて、
	インポートファイルの定義を作成して下さい。
	<li><b>フィールドマッピング:</b> このファイル内のすべてのフィールドをどのように扱うべきかを、
	次のウィンドウ内でCyclosに伝えて下さい。
	<li><b>支払いタイプマッピング:</b> 支払いタイプを定義するフィールド内の値がどのように支払いタイプにマップされるべきかをCyclosに伝えて下さい。
	これは、次のウィンドウで行われます。
</ol>
あなたが
これらのステップ（1度のみで十分です）を行った後にのみ、
あなたはあなたの銀行口座から受け取った取引ファイルを通じて、
新しい外部取引をインポートできるようになります。
ファイルから新しい取引をインポートする方法に関する概観を得るには、
<a href="#using"><u>ここをクリックして下さい</u></a>。
<hr>


<A NAME="external_accounts_list"></A>

<h3>外部口座をリスト表示する</h3>
このウィンドウは、すべての外部口座のリストを表示します。
<ul>
	<li><img border="0" src="${images}/edit.gif" width="16" height="16">
	外部口座を修正するには、このアイコンをクリックして下さい。
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">
	外部口座を消去したい場合は、このアイコンをクリックして下さい。
</ul>
あなたは下の「新しい外部口座」ボタンを通じて、新しい外部口座を追加できます。
<hr class="help">


<A NAME="new_edit_external_account"></A>

<h3>外部口座を新規作成／編集する</h3>
このページでは、外部口座と内部システムとそれに関連するメンバー口座を定められます。<br>
外部口座内の取引は、たいていユニットの作成（例えば、ローン）や破棄（例えば、両替）に関わる取引に関連します。
したがって、外部口座に関連したシステム口座は、通常、「無制限」タイプになるでしょう。
これに関するさらなる情報は、「口座作成」の
<a href="${pagePrefix}account_management#account_details"><u>
ヘルプファイル</u></a>にて見つけられます。
<hr class="help">


<A NAME="edit_file_mapping"></A>

<h3>ファイルマッピングを編集する</h3>
外部口座のための取引情報をインポートするためには、
外部口座のフィールドとCyclos内のフィールドの間のマッピングを定める必要があります。
外部口座を作成した後に初めての時には、新しいファイルマッピングを作成するように求められます。
以下のマッピングが利用可能です。
<ul>
	<li><b>タイプ: </b>CSVまたはカスタム（クラスファイル）<br>
	通常、取引ファイルは、値が区切り文字によって区切られるプレーンテキストを含みます。
	この場合、あなたは<a
		href="${pagePrefix}loans#csv"><u>CSV</u></a>オプションを使えます。<br>
	取引ファイルがもっと複雑なフォーマット、例えばxmlである場合には、
	そのフォーマットを扱えるカスタマイズされたクラスをプログラムすることが可能です。
	このドキュメントは、技術的な詳細に立ち入るようには意図されていませんが、
	あなたは以下のことを行う必要があります:
	<ol>
		<li>取引ファイルインポート（utilsパッケージ内）のCyclosインタフェースを実装するJavaクラスを作成する
		<li>それをクラスパスとサーバーのWEB-INF/classesの位置に置くか、
		それがjarにパッケージ化されている場合は共有されたlibディレクトリに置いて下さい。
	</ol>
	<li><b>列区切り: </b><br>
	そのファイル内で使われる区切り文字は、たいていカンマ「,」です。
	<li><b>ヘッダー行: </b><br>
	ヘッダー行（実際の値を含まない）の数。これらの行は無視されます。
	<li><b>数字フォーマット: </b><br>
	これには2つの可能なオプションがあります:
	<ul>
		<li><b>固定された位置:</b> 取引ファイル内の金額のフォーマットは区切りを持ちませんが、
		区切りが右から固定され計算される場合もあります。
		例えば、小数点位置2での50000という額は、500（またはカンマ付きで500,00）になります。<br>
		このオプションを選ぶと、その右にあるフィールドは「小数点位置」と呼ばれ、
		あなたは通常ここに「2」を入力します。
		<li><b>区切り付き:</b> 通常、区切りが使われます。
		あなたはフィールド「小数点区切り」（右にある）内でこれを定められます。
		これはたいてい点「.」またはカンマです。
	</ul>
	<li><b>マイナス文字: </b><br>
	取引ファイル内の金額フィールドのフォーマットが決してマイナスにならない場合もありますが、
	マイナスの数字については、区切られた列の中に特別な文字があります。
	これは、例えば、「-」またはD（デビット）になり得ます。
	例えば、金額列フィールド|-500,00|は、|D|500,00|と同じになり得ます（そこでは、|は列区切りです）。
	そのような場合、このフィールド内にこの文字を入力します。<br>
	通常、その額は、同じフィールド内にマイナスの文字を持っており、
	マイナスの列は必要とされません。
	<li><b>文字列引用符: </b><br>
	取引ファイルとCSVファイルは、しばしば、テキストのための（行と列が途切れるのを避けるための）文字列を含みます。
	ここでは、文字列引用符（たいていは"）を定められます。
	<li><b>日付フォーマット: </b><br>
	ここでは、日付フォーマットを定められます。
	あなたは、年の代わりにy、月の代わりにM（大文字でなければなりません）、日の代わりにdを使えます。
	dd/mm/yyまたはyyyy-MM-ddなどのような値の間の任意の区切りを使えます。
</ul>
「送信」をクリックsite、ファイルマッピングを送信して下さい。
「リセット」ボタンをクリックすると、すべてのファイルマッピングが削除され、
あなたは新しいものを作成するように促されます。
支払いタイプ（下のウィンドウ）は、ファイルマッピングをリセットする際には削除されません。
<hr class="help">


<A NAME="file_mapping_fields_list"></A>

<h3>ファイルマッピングフィールド</h3>
一度、ファイルマッピングフォーマットが定められると（下のウィンドウ）、
取引ファイルのフィールドをCyclosのフィールドへとマップできます。
リスト内のすべての行は、取引ファイル内の1つの行を示し、すべてのフィールドは1つの列です。
<br><br>初めてこのウィンドウを見た時には、リスト内には1つもフィールドがありません。
新しいフィールドマッピングを挿入するには、「新しいフィールドマッピングを挿入する」をクリックして下さい。
あなたは取引の書かれたファイル内のすべてのフィールドについて、これを繰り返さなければなりません。<br>
最初のフィールド（順序番号1の）は、取引ファイル内で最初の（左の）列になります。
フィールドの順序は、列順序に対応することを確認して下さい。
<br><br>一度リスト内に項目が入ると、いくつかのことを行えます。
<ul>
	<li>あなたは「フィールドマッピング順序を変更する」ボタンをクリックすることにより、フィールド順序を変更できます。
	<li><img border="0" src="${images}/edit.gif" width="16" height="16">&nbsp;
	このアイコンをクリックすると、このフィールドへのエントリーを変更できます。
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">&nbsp;
	このアイコンをクリックすると、リストからそのフィールドを消去します。
</ul>
<hr class="help">


<A NAME="edit_field_mapping"></A>

<h3>フィールドマッピングを新規作成／編集する</h3>
ここでは、フィールドごとにマッピングを定められます。
あなたは名称を入力することができますが、それはそのリスト内に表示される単なるテキストラベルです。
それにはどんな機能もありません。
フィールドドロップダウンボックス内で、以下のオプションを選択できます。
<ul>
	<li><b>無視された: </b>
	そのファイルが、Cyclosフィールドにマップされる必要がない追加的な列を含むならば、
	あなたは依然としてそれのためのマッピングを作成しなければなりませんが、「無視する」オプションを設定します。
	<li><b>メンバーID: </b>
	このオプションは、Cyclos内で使われる内部ID番号にマップするために使われ得ます。
	取引ファイルがCyclos内部（メンバー）IDを含むということはありそうもないですが、
	私たちは完全な一式のオプションを提供するために、そのオプションを用意します。
	<li><b>メンバー名: </b>
	取引ファイルが（Cyclos）ユーザー名を指定する場合、あなたはこのオプションにより列を定められます。
	<li><b>メンバーカスタムフィールド: </b>
	その取引ファイルがユーザー名を指定しない場合、ユーザーを特定するために
	カスタム（プロフィール）フィールドをマップすることが可能です。
	これは固有のカスタムフィールドでなければなりません。
	例えば、財務番号です。
	<li><b>支払いタイプ: </b>
	取引をインポートして、取引ファイルからの支払いを生成したい場合、あなたは支払いタイプを定めなければなりません。
	たいてい、取引ファイル内の取引は、複数の支払いタイプになります。
	例えば、預金、ローン返済などです。
	支払いのタイプは、区切られた列内のコードで指定されます。
	このオプションにより、どの列が支払いタイプを表示するかを定めます。
	異なる支払いタイプの可能な値は、このウィンドウの下の支払いタイプ機能で定められ舞うs。
	<li><b>支払日: </b>
	このオプションにより、取引の支払い日を含む列を指定できます。
	<li><b>支払額: </b> このオプションにより、取引の支払額を含む列を指定できます。
	<li><b>マイナス額の指標: </b> 支払額がマイナスまたはプラスの額であることを示さず、
	これが別の列内で指定されることもあります。
	このフィールドにより、あなたは	支払額フィールドがマイナスであるか否かを定められます。
	それは記号（例えば、「-」）または単語（例えば、「D」または「デビット」にすることができます。
</ul>
「送信」をクリックして保存して下さい。<br><br>
<b>注:</b> あなたは1つのフィールドを一度のみしか使えません。
それは、あなたがあるフィールドタイプ（例えば、支払日）を追加した場合、
あなたはそれを再び追加することはできないということを意味します（それはオプションとして表示されません）。
例外は、「無視された」フィールドで、あなたが無視したい（インポートしたくない）かもしれない様々な列が存在し得ます。<br>
メンバーID、メンバー名、メンバーカスタムフィールドは、すべてそのメンバーを定めるために使われるので、
あなたはそれら3つのフィールドタイプの1つのみをファイルマッピング内で使えます。
<hr class="help">


<a name="set_field_mappings_order"></a>
<h3>フィールドマッピング順序を設定する</h3>
このウィンドウでは、フィールドマッピングの順序を変更できます。
あなたが定めたフィールドのためのマッピングは、あなたがインポートしたい取引ファイル内のフィールドの順序と全く同一である必要があります。
<br><br>そのウィンドウは、非常に単純な方法で機能します。
ただフィールド名をクリックして、それをマウスであなたが望む場所にドラッグできます。
完了したら、「送信」ボタンをクリックして、結果を保存できます。
<hr class="help">


<A NAME="external_transfer_type_list"></A>
<h3>支払いタイプ（アクションマッピング）</h3>
このウィンドウは、取引ファイルが含められる支払いの可能なタイプのリストを表示します。
支払いタイプを追加するためには、その「支払いタイプ」フィールドとのフィールドマッピングが存在しなければなりません。
このウィンドウでは、このフィールド内のどのコード値がCyclos内の実際の支払いタイプにマップされるかをCyclosに伝えます。
あなたはこのフィールド内に存在するかもしれないすべてのあり得る値をマップしなければならないということを忘れないで下さい。
任意の理にかなった取引タイプにマップされないコードは、「なし」としてマップされます。
<ul>
	<li><img border="0" src="${images}/edit.gif" width="16" height="16">
	支払いタイプマッピングを修正するには、このアイコンをクリックして下さい。
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">
	支払いタイプマッピングを消去したい場合は、このアイコンをクリックして下さい。
</ul>
支払いタイプマッピングを追加するには、「新しい支払いタイプを挿入する」
というラベルの付いた「送信」ボタンをクリックして下さい。
<hr class="help">

<A NAME="edit_external_transfer_type"></A>
<h3>移転タイプを挿入／修正する</h3>
このページでは、あなたの銀行からの取引ファイルの支払いタイプフィールド内のコードをどのように解釈すべきかを定められます。
ここでは、特定のコードがどの取引タイプにマップされるべきかを定めます。
このフィールド内のすべてのあり得るコードについて、この手続きを繰り返して下さい。
<br>
名称と説明は、内部利用のためのものであって、機能を持っていません。
そのコードは、
<a href="#edit_field_mapping"> <u>支払いタイプフィールドマッピング</u></a>を含むフィールドのあり得る値の1つです。
一例については、下のリストを見て下さい。
<br>
以下のアクションが可能です。
<ul>
	<li><b>なし: </b>
	ここで、あなたは特定のコードがいかなるアクションも実行しないというでしょう。
	その取引はあなたの外部口座概観に現れ、それゆえ残高は正しいですが、
	それはCyclos内にいかなる支払いも生成しません。
	<li><b>メンバーへの支払いを生成する: </b>
	ここでは、一例が役に立ちます。
	取引ファイル内の支払いタイプ列が様々な可能な値（コード）を持っており、
	それらのうちの1つが「DEP1」、つまり、その取引が銀行口座における預金であることを示す場合です。
	この特定の支払いタイプに、システム口座からメンバーへの支払いを自動的に生成させたいならば、
	このオプションが選択されるべきです。
	<li><b>システムへの支払いを生成する: </b>
	これは稀な場合でしょうが、任意の可能なオプションを提供するために用意されています。
	それは、外部口座に入ってきた取引が、メンバーからシステムへの支払いをCyclos内に生成することを意味します。<br>
	一例は、メンバーが彼らのメンバーシップ手数料を国民通貨で期間内に支払ったかどうかを確認するために、
	国民通貨での簿記をCyclosにインポートしたい場合です。
	この場合、あなたは組織のための口座を国民通貨で作成する必要があり（システムの銀行口座を反映させるため）、
	加えて、メンバーのための追加的な口座を国民通貨で作成する必要があるでしょう。
	これにより、あなたはこれらの作成された口座によって銀行口座取引を反映させることができ、
	メンバーが彼らのメンバーシップ手数料を支払ったかどうか確認できます（それに加えて、それに関する統計も実行できます）。
	<li><b>ローンを放棄する: </b>
	一部のシステムは、外部で（例えば、伝統的貨幣で）支払いできる<a href="${pagePrefix}loans"><u>ローン</u></a>をCyclos内に持っています。
	そのローンが外部で返済された時、その状態は内部Cyclos通貨での返済のために取っておかれているので、
	あなたはCyclos内の状態を返済済みに変えたくありません。
	そのような場合、新しい状態は「放棄済み」でしょう。
	ローン返済が行われた時、ローン状態はこれらの支払いタイプに従って自動的に変更できます。
	<li><b>調停する: </b>
	調停状態は、内部Cyclos支払いに与えられる状態で、それが外部の「逆」支払いを持ち、管理上確認済みであることを明記します。
	それは、Cyclos口座（システムおよびメンバー）の集合の残高と外部口座にある残高を制御するために使われます。
</ul>
<hr class="help">

<a name="using"></a>
<h2>外部口座の使用</h2>
あなたは外部取引を外部口座へとインポートして、その後、それらを処理することができます。
あなたは取引について外部口座を検索することもできます。

<i>どこで見つけられる？</i>
<br>
外部口座概観は、「メニュー: 簿記 > 口座概観」を通じて見つけられます。
<br><br><i>どうやって動かす？</i><br>
一度、外部ファイルのためのマッピング（ファイルの一番上を見て下さい）を設定すると、
あなたの銀行からのファイルから取引のインポートを開始できます。
これを機能させるために、以下のアクションを行って下さい:
<ol>
	<li>「メニュー: 簿記 > 口座概観」に行き、
	<img border="0" src="${images}/import.gif" width="16" height="16">&nbsp;インポートアイコンをクリックsite、
	インポートモジュールに行って下さい。
	<li>そのファイルをインポートして下さい。
	これがエラーになる場合、あなたのインポートが成功するまで、それらを訂正して下さい。
	<li>インポートされた取引の概観に行って下さい。
	これは検索結果ウィンドウ（インポートボタン付きのウィンドウの上）を通じて、
	<img border="0" src="${images}/preview.gif" width="16" height="16">&nbsp;
	ビューアイコンをクリックすることにより、これを行えます。
	<li>不完全な取引を削除または回復し、保留中の取引を確認して、それらを「チェック済み」状態へと変えて下さい。
	このすべては、各取引の
	<img border="0" src="${images}/preview.gif" width="16" height="16">&nbsp;ビューアイコンを通じて行えます。
	<li>この取引概観の上の「処理」ボタンを通じて、チェック済み取引を処理して下さい。
</ol>
<hr>

<A NAME="external_accounts_overview"></A>
<h3>外部口座概観</h3>
このページは、システムのために設定されたすべての外部口座をリストで示します。
名称列は、その外部口座の名称を表示し、口座残高はすべてのインポートされた取引の合計を表示します。
<ul>
	<li><img border="0" src="${images}/import.gif" width="16" height="16">
	矢印アイコンをクリックすると、その口座についてのインポート機能に入ります。
	それにより、あなたは外部取引をファイルからインポートできます。
	すべての過去のインポートの概観を得ることもできます。
	<li><img border="0" src="${images}/preview.gif" width="16" height="16">
	既にインポートされた取引を閲覧および処理するには、虫眼鏡アイコンをクリックして下さい。
</ul>
<hr class="help">

<A NAME="external_transfer_import_new"></A>
<h3>外部移転インポート新規</h3>
このウィンドウでは、新しい外部取引をインポートできます。
ただファイルを選んで「送信」をクリックして下さい。
そのファイルがシンタックスエラーによって読めなかった場合は、
そのエラーを引き起こしている行とフィールドを特定するエラーレポートが現れるでしょう。
<hr class="help">

<A NAME="external_transfer_import_list"></A>
<h3>外部移転インポートリスト</h3>
このウィンドウでは、期間によってファイルインポートを検索できます。
あなたは日付を入力するために、日付選択機能(
<img border="0" src="${images}/calendar.gif" width="16" height="16">
)を使っても良いでしょう。
<hr class="help">

<A NAME="external_transfer_import_result"></A>
<h3>外部移転インポート結果</h3>
このウィンドウは、すべてのインポートされた取引ファイルのリストを表示します。
<ul>
	<li><img border="0" src="${images}/preview.gif" width="16" height="16">
	インポートされた取引を閲覧および処理するには、虫眼鏡アイコンをクリックして下さい。<br>
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">
	インポートされた取引を再び削除するには、消去アイコンをクリックして下さい。<br>
	注: 「チェック済み」または「処理済み」の状態にある取引を持つインポートは消去できません。</ul>
<hr class="help">

<A NAME="external_account_history"></A>
<h3>外部口座履歴</h3>
このウィンドウでは、インポートされた取引を検索できます。
その機能は、すべてのインポートされたファイル内を検索します。
何もオプションを選択しない検索は、所与の外部口座についてのすべてのインポートされた取引を表示します。
以下の検索オプションが利用可能です:
<ul>
	<li><b>タイプ: </b>
	このオプションにより、支払いタイプ（インポート設定内で定義された）ごとに検索できます。
	<li><b>状態: </b>
	<ul>
		インポートされた取引は、以下の状態の1つになり得ます。
		<li><b>保留中: </b>
		その取引はインポートされましたが、まだ確認されていません。
		それはまだ「インポートされた残高」に（簿記機能のメインページで）影響を与えておらず、何のアクションも生成していません。<br>
		注: 保留中状態にあるインポートされた取引を消去することも可能です。
		<li><b>チェック済み: </b>
		これらは、確認されており、「チェック済み」<a href="#external_transfers_history_result"><u>状態</u></a>に置かれている取引です。
		<li><b>処理済み: </b>
		これらは、チェック済みの状態に置かれた後に処理された取引です。
	</ul>
	<li><b>ログイン名／メンバー: </b>
	特定のメンバーによる取引を検索します。
	<li><b>下限額／上限額: </b>
	額の範囲によって検索します。
	<li><b>開始日／終了日:</b>
	期間によって検索します。
</ul>
そのウィンドウの下には、アクション（3つのボタンを表示する）があります。
これらは、左から右に:
<ul>
	<li><b>インポートリストへ:</b> これにより、インポートファイルの概観に移動します。
	そこでは、新しい取引ファイルをインポートすることもできます。
	<li><b>支払いを処理する: </b>
	これは、あなたが1つ以上の取引を処理することができる処理ウィンドウを開きます。<br>
	その処理は、
	<ul>
		<li>（外部口座から）出て行く支払いを調停すること
		<li>銀行口座に入ってきた支払いに関連した内部Cyclos支払いを生成すること
		<li>外部口座に入ってきた支払いに関連した（Cyclos）ローン支払いを放棄すること
	</ul>
	のいずれかになり得ます。
	処理ボタンは、検索結果リスト内のすべての取引に（それらが選択されているか否かに関わらず）適用されます。
	取引はその状態が「チェック済み」である場合にのみ処理できるということに留意して下さい。
	<li><b>新しい支払い: </b>
	取引が正しくインポートされなかった場合には、それを手動で挿入することが可能です。
</ul>
これらの機能に関するさらなる情報は、その機能ウィンドウ自体で発見できます。
<hr class="help">

<a name="status"></a>
<h3>取引状態</h3>
各々のインポートされた取引には状態があります。その状態は、以下の値を持ち得ます:
<ul>
	<li><b>保留中</b> <img border="0" src="${images}/pending.gif" width="16" height="16">:
	その取引はインポートされていますが、効力を持っていません。
	それはさらなるアクションのために保留中です。<br>
	その取引タイプが「調停可能である」としてチェックされた場合、この状態はシステム口座概観の中にも現れます。
	この方法で、あなたは口座概観ページから直接、調停状態を辿ることができます。<br>
	保留中状態の取引のみを消去できます。
	<li><b>チェック済み</b> <img border="0" src="${images}/checked.gif" width="16" height="16">:
	その取引は、確認されており「チェック済み」です。
	これは、それが外部口座残高に入ることを意味します。<br>
	「チェック済み」状態の取引を「保留中」に戻すことが可能です。
	<li><b>不完全</b> <img border="0" src="${images}/incomplete.gif" width="16" height="16">:
	その取引は、インポートされていますが、1つ以上のフィールドを正しくマップできませんでした。
	例えば、インポートされた取引の中のメンバーがCyclos内に存在しない場合です。<br>
	<li><b>調停済み</b> <img border="0" src="${images}/conciliated.gif" width="16" height="16">:
	その取引は処理されました。これは、
	それが外部口座残高の一部であり、それがCyclos内にアクション（例えば、内部Cyclos支払いやローン放棄）を引き起こすことを意味します。<br>
	取引タイプが「調停可能である」としてチェックされた場合、この状態はシステム口座概観の中にも表示されます。
	この方法で、あなたは口座概観ページから直接、調停状態を辿ることができます。<br>
	処理された取引には別の状態を与えられず、消去することもできません。
</ul>
<hr class="help">


<A NAME="external_transfers_history_result"></A>
<h3>外部移転</h3>
このウィンドウは、上の検索ウィンドウの結果を表示します。
標準では、すべてのインポートされた取引を表示します。
タイプ列は、前に状態アイコンを表示します。
その状態のための可能な値の概観のためには、<a href="#status"><u>ここをクリックして下さい</u></a>。
額と日付の列は自明です。
<br><br>
各取引に関して、以下のアクションが可能です。
<ul>
	<li><img border="0" src="${images}/preview.gif" width="16" height="16">
	あなたは、プレビューアイコンを選択して、調停済みと処理済みの支払いに入れます。
	それらの支払いは変更できません。
	ただし、チェックされた取引を保留中に戻して設定することが可能です。
	<li><img border="0" src="${images}/edit.gif" width="16" height="16">
	あなたは、編集アイコンを選択することにより、保留中の状態にある取引からの取引データを修正できます。<br>
	<li><img border="0" src="${images}/delete.gif" width="16" height="16">
	その取引を消去するには、消去アイコンをクリックして下さい。<br>
</ul>
<hr class="help">


<A NAME="external_transfers_history_summary"></A>
<h3>外的移転履歴概要</h3>
このウィンドウは、リストで示された取引の合計の概観とレポートを示します。
<br><br>注: 一番上のウィンドウの検索の結果である取引のみが数えられます。
何もオプションを選択しない検索は、所与の外部口座についてのすべてのインポートされた取引を表示します。
<hr class="help">

<A NAME="new_external_transfer"></A>
<h3>新しい外部移転</h3>
取引を手動で追加することが可能です。
通常、取引インポートはすべての取引を正しくインポートするように設定できるので、これは必要ではないはずです。
しかし、それが必要とされる（稀な）場合には、このウィンドウ内で行えます。
<br>
入力フィールドは自明です。
<hr class="help">

<A NAME="edit_external_transfer"></A>
<h3>外部移転を閲覧および修正する</h3>
このページでは、インポートされた移転の詳細を閲覧できます。
移転が保留中<a href="#status"><u>状態</u></a>にある場合、あなたはその特性を修正できます。<br>
入力フィールドは自明です。
<hr class="help">

<A NAME="external_transfer_process"></A>
<h3>外部移転処理</h3>
このページでは、支払いを処理できます。
支払いは、<a href="#status"><u>「チェック済み」状態</u></a>になければならず、
そうでなければ、それは処理の準備ができている取引のリスト内に表示されないということに留意して下さい。
<br><br>そのウィンドウは、処理可能な支払いの概観を与えます。
各項目内で、上の行は取引ファイルから読み込まれる元の行を表示し、下の行はあなたが送信をクリックした後に処理される取引を表示します。
最初の列のチェックボックスにチェックすることにより、あなたが処理したい取引を選択して下さい。
これは、もし日付や額が正しくなければ、それらを修正することも可能にします。
<br>
「送信」をクリックすると、選択された取引を処理します。
<br><br>
3つのタイプの処理があります。
<ul>
	<li><b>調停する: </b>
	このオプションは、内部（Cyclos）ユニットが外部で裏付けられるシステム（例えば、銀行口座にある伝統的な貨幣）に共通です。
	取引の集合（外部取引とCyclos取引）の調停は、両方の取引が管理上関連づけられるために結び付けられることを意味します。
	これは、外部口座の口座概観機能とシステム口座概観機能において、支払いの前に
	<img border="0" src="${images}/conciliated.gif"
		width="16" height="16">とともに表示されます。
	これらの機能の検索ウィンドウには、調停状態によって検索するオプションがあります。
	取引をCyclos内の調停可能な取引タイプと調停できるようになるためには、	
	取引タイプ設定でオプション「調停可能である」をチェックしなければなりません。<br>
	<li><b>支払いを生成する: </b><br>
	入ってきた（外部）支払い（プラスの額のみ）は、Cyclos支払い（システムからメンバーへ、またはその逆）を生成するように設定できます。
	支払いを処理するには、それが選択される必要があります。
	一度、取引が選択されると、額と日付を修正することが可能ですが、これは稀な場合にのみ必要とされます。<br>
	生成された支払いは、自動的に調停状態を持ちます。
	<li><b>ローン支払いを放棄する: </b><br>
	Cyclos内のローンは、それが返済された時に、管理上「支払い済み」状態に入ります。
	Cyclosローンが外部で返済され得るシステムでは、それらが返済済みであるということを示す状態を、それらのローンに与えることが可能です。
	この状態は「放棄済み」と呼ばれます。
	外部の入ってきた支払いに、放棄済みローン支払いを生成させることが可能です。<br>
	外部口座設定のためには、特定のタイプがあります。
	そのような外部支払いが処理された場合、Cyclosは同じ額と日付で未決済のローン支払いを検索し、最も近い一致を示します。
	一致するローン支払いが複数ある場合、それらはすべて表示され、管理者は正しいものを選べます。
	生成されたローン放棄支払いの後に、外部口座概観の中で調停状態が表示されます。
</ul>
<hr class="help">

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
