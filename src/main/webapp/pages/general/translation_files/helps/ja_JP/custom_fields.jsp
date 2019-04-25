<div style="page-break-after: always;"
<br><br>しばしば、Cyclosを運用している組織は、彼ら自身に固有のタイプの情報をCyclosのデータベース内に蓄えたいものです。そのために、データベース内に保持されるフィールド、アプリケーション内で見えるフィールドを管理することが可能です。<br>
管理者は、新しいフィールドを追加したり、既存のフィールドを修正したり、フィールドを消去したりすることができます。
これは、メンバー、管理者、<a href="${pagePrefix}operators"><u>オペレータ</u></a>のプロフィール、広告、<a
	href="${pagePrefix}loans"><u>ローン</u></a>、<a
	href="${pagePrefix}loan_groups"><u>ローングループ</u></a>、<a
	href="${pagePrefix}member_records"><u>メンバー記録</u></a>.<br>
例えば、組織がメンバーの靴のサイズを示す追加的な<a
	href="${pagePrefix}profiles"><u>プロフィール</u></a>フィールドを必要とする場合、管理者は新しいフィールドを作成し、名称、タイプ、サイズ、可視性、許可、位置、妥当性条件のような、その新しいフィールドの様々な属性とその他の振る舞いや設定を定められます。<br>
フィールドは、<a href="${pagePrefix}groups"><u>グループ</u></a>に対して割り当てることができます。
一例を挙げれば、これにより、消費者と事業者に異なる登録フォームやプロフィールを持つことができます。
上の例では、それによりその組織は、靴のサイズが異なるメンバーに対して、異なるポリシーを作成できます。<br>
Cyclosには1組の標準カスタムフィールドが備わっていますが、それももちろん管理可能です。
もちろん、データベース内のすべてのフィールドがカスタムフィールドなわけではありません。
多くのフィールドは非常に重要なので、削除も修正もできません。<br>

<i>どこで見つけられる？</i><br>
カスタムフィールドは、メインメニュー「カスタムフィールド」を通じて管理できます。<br><br><i>どうやって動かす？</i><br>
カスタムフィールドを管理するためには、
<a href="${pagePrefix}groups#manage_group_permissions_admin_system"><u>許可</u></a>を持っている必要があります。これらは管理者に対してのみ割り当てることができ、「カスタムフィールド」ブロック下で見つけられます。
<hr>

<a name="list_custom_fields"></a>
<h3>カスタムフィールドをリストにする</h3>
このヘルプは、メンバー、管理者、
<a href="${pagePrefix}operators"><u>オペレータ</u></a>、
<a href="${pagePrefix}advertisements"><u>広告</u></a>、
<a href="${pagePrefix}loans"><u>ローン</u></a>、
<a href="${pagePrefix}loan_groups"><u>ローングループ</u></a>、
<a href="${pagePrefix}member_records"><u>メンバー記録</u></a>のためのカスタムフィールドに当てはまります。
<br><br>そのリストは、この主題のために定められたすべてのカスタムフィールドを表示します。<br>
メンバー、管理者、オペレータのフィールドは、彼らのプロフィール内に表示されます。
Cyclosに備わっている標準のデータベースには、既にいくつかの定められたカスタムメンバーフィールドがあります。<br>
ローンとローングループのフィールドは、ローンとローングループのページ内に表示され、広告フィールドは、広告ページ内に表示されます。
<br><br>フィールドの名称と設定は、編集アイコンを選択することによって修正できます。
そのページのヘルプファイル内で、カスタムフィールド設定についての詳細な情報を見つけられます。<br>
あなたは赤い消去アイコンをクリックすることによって、フィールドを消去できます。
カスタムフィールドの消去は、既に使われていない場合にのみ可能であることに注意して下さい。
データベース内の任意のフィールドが情報を持つや否や、そのフィールドの消去は不可能になります。
そのような場合は、すべてのグループを非選択にすることによって、そのフィールドを隠すことができます。
私たちは、これに反するアドバイスをします。たいていの場合、単にそのフィールドを隠した方が良いです。
<br><br>「フィールド順序を変更する」送信ボタンを選択することにより、そのページ内にフィールドが現れる際の順序を変更できます。<br>
「新しいカスタムフィールド」送信ボタンを選択することにより、新しいプロフィールフィールドを挿入できます。<br>
<hr class="help">

<a name="order_custom_fields"></a>
<h3>カスタムフィールド順序を設定する</h3>
このヘルプは、メンバー、管理者、
<a href="${pagePrefix}operators"><u>オペレータ</u></a>、
<a href="${pagePrefix}advertisements"><u>広告</u></a>、
<a href="${pagePrefix}loans"><u>ローン</u></a>、
<a href="${pagePrefix}loan_groups"><u>ローングループ</u></a>、
<a href="${pagePrefix}member_records"><u>メンバー記録</u></a>のためのカスタムフィールドに当てはまります。
<br><br>ここでは、そのページ内にカスタムフィールドが表示される順序を定められます。
これを行うためには、フィールド名にマウスポインタを重ねて、マウスを左クリックして押したまま、その名称を新しい位置へと「ドラッグ」して下さい。<br>
その後、「送信」を選択して下さい。
<hr class="help">

<a name="edit_custom_fields"></a>
<h3>カスタムフィールドを新規作成／編集する</h3>
このウィンドウでは、カスタムフィールドの属性を設定できます。
一部のオプションは作成時にしか変更できませんので、これは正しく行うように注意して下さい。
フィールドが使用されていると、変更するのは不可能かもしれません。<br>
すべてのオプションがすべてのタイプのカスタムフィールドについて利用可能ではないということに注意して下さい。
現時点では、メンバー（プロフィール）フィールドは、最も可能なオプションを持っています。
<br><br>以下のオプションが存在します:
<ul>
	<li><b>名称:</b> これはCyclos内で見えるフィールドの名称または「ラベル」です。
	<li><b>内部名:</b> これはそのフィールドの内部名です。
	それは開発目的のためにのみ使われます。
	<li><b>データタイプ:</b> データタイプでは、フィールドのタイプを指定できます。6つのフィールドタイプがあります。
	<ul>
		<li><b>文字列:</b> 文字列は任意の文字があるテキストにすることができます。
		E-mailや郵便番号のような必須フィールドの「入力パターン」を指定したい場合は、下のフィールドでそのようなマスクを作成できます。
		マスクは正しいフォーマットで情報を入力するようにユーザーに強制します。
		送信後、その入力が正しいことを確認するための追加的なチェックがあります。<br>
		入力マスクについてのドキュメントは、プロジェクト<a
		href="http://javascriptools.sourceforge.net/docs/manual/InputMask_mask.html" target="_blank">JavaScript tools</a>のサイトで見つけられます。
		<li><b>列挙:</b> 列挙タイプは、地域（「北」、「東」、「南」、「西」）のような値のリストを持つことを意味します。
		列挙されたリストは、ドロップダウンボックスまたはラジオ選択ボタンとして提示されます。
		列挙が選択された場合、「すべての選択されたラベル」という名前の追加的な入力フィールドが示されます。
		このラベルは、標準でドロップダウン内に表示されます。
		地域の例では、そのラベルは「すべての地域」と表示されます。
		<li><b>整数:</b> このタイプは、そのフィールドが、小数カンマまたは小数点（あなたの言語に依ります）のない数字にのみなり得ることを意味します。
		<li><b>少数:</b> これは、そのフィールドが小数カンマまたは小数点のある数字であることを意味します。
		精度とフォーマットは、<a
			href="${pagePrefix}settings#local"><u>「ローカル設定 > 数字フォーマット」</u></a>内で定められます。
		<li><b>日付:</b> このフィールドは、日付のみを含むことができます。日付フォーマットは、<a href="${pagePrefix}settings#local"><u>「ローカル設定 > 国際化 > 日付フォーマット」内で定められます。</u></a>.
		<li><b>ブール:</b> ブールは、可能な値が「選択」と「非選択」（「真」と「偽」）という2つのみの単なるチェックボックスです。</ul>
	<li><b>親フィールド:</b> ここでは、このフィールドについて選べる選択肢が、別のフィールドの値に依存するかどうかを定められます。
	さらなる説明については、<a href="#parent_field"><u>ここ</u></a>をクリックして下さい。
	<li><b>フィールドタイプ:</b> データタイプに応じて、様々なフィールドタイプがあります。
	以下のタイプが存在します:
	<ul>
		<li>テキストボックス（文字列(=テキスト)のための、1行またはテキストエリア(5行)。）
		<li>列挙（ドロップダウン選択）のための選択ボックスまたはラジオボタン。
		<li>整数、小数、日付のみのためのテキストボックス。
	</ul>
	<li><b>フィールドサイズ:</b> フィールドサイズは、「微小」、「小」、「中」、「大」にすることができます。
	それらの厳密な、絶対的なサイズは、スタイルシートファイル内で定められます。
	ウィンドウのフルサイズである「フル」サイズも指定できます。
	「標準」オプションは、各々のフィールドタイプについて異なりますが、しばしば、利用可能なスペースの約8%を意味します。
	例えば: この画面上の「名称」フィールドは、標準サイズです。
	<li><b>閲覧可能者（広告のみ）:</b> ここでは、誰がその広告カスタムフィールドを閲覧できるかを定められます。
	これは以下のものになり得ます:<br>
	すべてのユーザー（すべての他のメンバー、仲介者、管理者に加えて所有者も）、
	すべての仲介者と管理者、あるいは、管理者のみ。
	<li><b>検索での表示（支払いフィールドのみ）:</b> これがチェックされている場合、カスタム支払いフィールドが口座概要内のフィルタとして表示されます。
	支払いタイプがローンの場合、それは管理者のためのローン検索内に表示されます。
	<li><b>結果リストでの表示（支払いフィールドのみ）:</b> これがチェックされている場合、カスタム支払いフィールドが検索結果リスト内の列として表示されます。
	支払いタイプがローンの場合、それは管理者のためのローン検索結果リスト内に表示されます。<br>
	そのフィールドは常にCSVでのエクスポートおよび印刷に含まれるということに留意して下さい。たとえ、このオプションがチェックされていない場合でもそうです。
	<li><b>プロフィール表示での閲覧可能者:</b> ここでは、そのフィールドを誰が閲覧できるかを定められます。
	以下のオプションが利用可能です:
	<ul>
		<li><b>なし:</b> そのフィールドは、システム内のどのユーザーにも見えません。
		<li><b>管理者:</b> 管理者のみが、そのフィールドを見ることができます。
		<li><b>仲介者:</b> 管理者とそのメンバーの仲介者のみが、そのフィールドを見ることができます。
		<li><b>メンバー登録時:</b> メンバーは、一般登録ページで登録する時のみ、そのフィールドを見ることができます（彼のプロフィールでは見られません）。
		仲介者と管理者は、そのフィールドを見ることができません。
		<li><b>メンバー、登録時ではない:</b> メンバー、仲介者、管理者は、そのフィールドを見ることができますが、
		そのフィールドは登録ページでは見えません。
		<li><b>メンバー:</b> メンバー、仲介者、管理者は、そのフィールドを見ることができます。
		<li><b>他のメンバー:</b> メンバー、仲介者、管理者、そのメンバーグループを見る許可を持つシステム内の他のメンバーが、
		そのフィールドを見ることができます。
	<li><b>編集可能者:</b> ここでは、そのフィールドを誰が修正できるかを定められます。（その許可は、「プロフィール表示での閲覧可能者」オプションと同様の階層構造で機能します。）
	<li><b>メンバー検索での閲覧可能者:</b> ここでは、メンバー検索ページ内で、そのフィールドが誰に対して表示されるかを定められます。（その許可は、閲覧許可と同様の階層構造で機能します。）
	<li><b>広告検索での閲覧可能者:</b> ここでは、広告検索ページ内で、そのフィールドが誰に対して表示されるかを定められます。（その許可は、閲覧許可と同様の階層構造で機能します。）
	<li><b>キーワード検索に含める:</b> このオプションにより、メンバーおよび広告検索内のキーワードフィールド検索オプションのために利用可能にすることができます。<br>
	メンバーキーワード検索では、メンバー検索においてのみで（メンバーのみ）含めるか、メンバー検索と広告検索の両方のために含めるかを選べます。
	後者の選択肢が選ばれた場合、メンバーはメンバー（プロフィール）フィールドを使って広告を検索できます。
	これは複合的な検索についてのみ有用であることに留意して下さい。
	単一のメンバープロフィールフィールドが合致する広告検索は、このメンバーのすべての広告を表示するでしょう。
	<li><b>ローン検索での閲覧可能者:</b> ここでは、ローン検索ページ内で、そのフィールドが誰に対して表示されるかを定められます。（その許可は、閲覧許可と同様の階層構造で機能します。）
	<li><b>メンバーが隠せる:</b> ここでは、誰がフィールドを隠すオプションを持つかを定められます。（その許可は、閲覧許可と同様の階層構造で機能します。）
	<li><b>メンバー印刷に表示:</b> ここでは、メンバー検索ページ内で、そのフィールドが誰に対して表示されるかを定められます。（その許可は、閲覧許可と同様の階層構造で機能します。）
	<li><b>妥当性条件:</b> 以下の妥当性条件を指定できます:
	<ul>
		<li><b>必須:</b> これが選択された場合、フィールドは必須になり、そのフィールドの隣に赤いアスタリスクが表示されます。
		ユーザーは値を入力しなければなりません。
		<li><b>固有:</b> 固有が選択されると、そのフィールド値は、システム内で一度のみ存在し得ます。フィールドがパスポート番号や財務登録番号のように固有であることを確実にする必要がある場合に、これを選択できます。
		<li><b>最大長および最小長:</b> そのフィールドが文字列ならば、最小長と最大長を定められます。
		ユーザーはこの範囲内でのみ、そのフィールドの長さに入力できます。
		<li><b>認証クラス:</b> 正規表現（上の入力パターンフィールド内）では扱えないもっと複雑な認証が必要な場合、
		あなた独自の認証クラスを書くことができます。<br>典型的な状況は、
		あなたが入力の計算に基づく認証、あるいは、リモート認証を行いたい場合です。<br>
		認証クラスを実施する方法に関する情報は、
		<a
			href="http://project.cyclos.org/wiki/index.php?title=Setup_%26_configuration#Custom_fields"
			target="_blank"><u>Wiki</u></a>にて見つけられます。</ul>
	<li><b>説明:</b> ここでは、そのフィールドの説明を設けることができます。
	管理者は、そのフィールドの用法を説明できます。
	説明は編集フィールド内にのみ表示されます。
	<li><b>グループに対してフィールドを有効化する:</b> ここでは、そのフィールドを有するグループを選択できます。
</ul>
<hr class="help">

<a name="parent_field"></a>
<h3>親フィールド</h3>
あるフィールドに親フィールドがある場合、それは、このフィールドのために選べる選択肢が、別のフィールドの値に依存することを意味します。
<br>
例えば、あなたは「省」というカスタムフィールドと「市」というカスタムフィールドを持っているかもしれません。
ユーザーが省として「南部」を選択すると、「市」フィールドは「南部」という省の中のすべての市をリストにするでしょう。
この場合、あなたは「省」フィールドを「市」フィールドのための<i>親フィールド</i>として特徴付けられるでしょう。
<br>
「親フィールド」では、他の既存のフィールドから、現在のフィールドのための親フィールドとして割り当てるフィールドを選べます。
「親フィールド」は常には見えないということに注意して下さい。
それは列挙されたタイプについてのみ見えます。
<!--  check this: is dit waar?? -->
親フィールドの各々の値について、あなたは、<a href="#possible_values"><u>可能な値</u></a>ウィンドウ（「送信」をクリックした後に利用可能）を通じて、子フィールドに異なる組の値を定められます。
<hr class="help">


<a name="possible_values"></a>
<h3>カスタムフィールドに対する値</h3>
このウィンドウは、そのフィールドに対して可能な値のリストを表示します。
<br><br>消去アイコンを選択することにより、値を消去できます。
これはその特定の値が使われていない場合にのみ機能します。
すべての使われている値をそのリストの別のものに割り当てることにより、値を「空にする」ことが可能です。（これは、値の編集においてさらに説明されます。）
<br><br>
あなたのフィールドに<a href="#parent_field"><u>親フィールド</u></a>がある場合には、「新しい値」をクリックする前に、まず、あなたが新しい値を定めたい親フィールドの適切な値を選択して下さい。
あなたはこのために「戻る」ボタンと「新しい値」ボタンの間のセレクターを使えます。
<hr class="help">

<a name="edit_possible_value"></a>
<h3>新しいフィールドの値を挿入する／フィールドの値を修正する</h3>
<br><br>以下のオプションを利用可能です:

<ul>
	<li><b>親フィールド名:</b> あなたのフィールドに<a
	href="#parent_field"><u>親フィールド</u></a>がある場合、あなたの新しい値が割り当てられることになる親フィールドの値は、このラベル内に表示されます。<br>
	（その親フィールドの他の値のために新しい値を定めたい場合は、<a
	href="#possible_values"><u>前の画面</u></a>に戻って下さい。）
	<li><b>値:</b>ここでは、値の名称を指定できます。
	値を記入して「送信」を選択して下さい。
	その値は、値リスト内にアルファベット順で表示されます。
	<li><b>標準:</b> 選択されると、この値はそのフォームが表示される時に事前選択されます。
	カスタムフィールドごとに1つの標準値のみが存在し得ます。
	<li><b>有効化:</b> これがチェックされると、その値が可能な選択オプションとして表示されます。
	有効化が選択されていない場合、その値は表示されますが、その値内にデータがある場合に限ります。
	この方法により、過去に使われていた値を使わないようにしつつ、古い（使われていない）値が失われないようにすることができます。
	<li><b>頻出値の置き換え:（編集モードのみ）</b> 値を編集している時には、この値タイプのためのデータを含むすべてのフィールドの値を別のものに移動することができます。
	これにより、値リストページ内の値を削除することが可能です。（その値が使われていない場合のみ、削除が可能です。）
	既存の値を避けたい場合は、上で説明したように、その値を無効化することもできます。<br>
	（値の削除は、<a
	href="#possible_values"><u>前の画面</u></a>におけるリストページ内で行えます。）
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
<br><br>
</div>