<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/printheader.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="print">

	<h1 align="center">Nájemní smlouva č. ${smlouva.identifikator }</h1>
	<h2 align="center">uzavřená dle zák. č. 89/2012 Sb. občanského
		zákoníku mezi:</h2>

	<p>
		${smlouva.klient.lastName} ${smlouva.klient.firstName}<br>
		${smlouva.klient.street }<br> ${smlouva.klient.zip }
		${smlouva.klient.city }<br> (dále jen <b>propachtovatel</b>)
	</p>
	a
	<p>
		ZAS Jašek<br> Polnička<br> 59102 Žďár nad Sázavou<br>
		(dále jen <b>pachtýř</b>)
	</p>

	<h2>1. ÚVODNÍ PROHLÁŠENÍ</h2>
	<p>
		1.1 Propachtovatel má ve svém vlastnictví pozemky:<br> <br>
		<c:set var="column_totals" value="0"/>
	<table border="1" style="border: 2px solid black;">
		<thead>
			<th>Číslo parcely</th>
			<th>Katastr</th>
			<th>Výměra</th>
		</thead>
		<c:forEach var="podil" items="${smlouva.klient.podily}">
			<c:forEach var="parsml" items="${podil.lv.parcely }">
				<tr>
					<td>${parsml.kmenoveCislo}/${parsml.podlomeniCisla }</td>
					<td>${parsml.lv.katastr.kod } (${parsml.lv.katastr.nazev })</td>
					<td>${parsml.vymera }</td>
					<c:set var="column_totals" value="${column_totals + parsml.vymera}" />
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	<br>o celkové výměře  <b><fmt:formatNumber value="${column_totals}" maxFractionDigits="2"/> m<sup>2</sup></b> (dále jen „pozemky“).

	<h2>2. DOBA PACHTU</h2>
	<p>
		2.1 Tato smlouva se uzavírá na dobu určitou od <b><fmt:formatDate
				value="${smlouva.ucinnostOd}" pattern="d.M.yyyy" /> </b>do <b><fmt:formatDate
				value="${smlouva.ucinnostDo}" pattern="d.M.yyyy" /></b>.
	<h2>3. PACHTOVNÉ</h2>
	<c:set var="pachtovne" value="${(column_totals * smlouva.sazbaHa)/10000 }"/>
	<p>
		3.1 Pachtovné činí <b>${smlouva.sazbaHa},-</b> Kč/ha/hospodářský rok
		tj. celkem <b><fmt:formatNumber value="${pachtovne}" maxFractionDigits="0"/>,-</b> Kč/hospodářský rok. Hospodářským rokem se rozumí
		období od 1.10. do 30.9.
	</p>
	<p>3.2 Pachtovné bude pachtýřem uhrazeno vždy nejpozději do 31.12.
		příslušného hospodářského roku a to převodem na účet propachtovatele
		č.ú. ………………………………</p>
	<p>3.3 Pro případ prodlení v úhradě pachtovného si smluvní strany
		sjednávají smluvní pokutu ve výši 0,1% za každý den prodlení. Prodlení
		v úhradě pachtovného delší než 30 dnů se dále považuje za podstatné
		porušení podmínek této smlouvy pachtýřem a propachtovatel je v takovém
		případě oprávněn vypovědět tuto pachtovní smlouvu s okamžitou
		platností (tj. bez výpovědní doby).</p>
	<p>3.4 Daň z nemovitých věcí hradí propachtovatel.</p>

	<h2>4. PRÁVA A POVINNOSTI STRAN</h2>
	<p>4.1 Pachtýř je oprávněn užívat pozemky k zemědělské činnosti a
		výrobě.</p>
	<p>4.2 Pachtýř se zavazuje užívat pozemky s péčí řádného hospodáře
		a v souladu se zásadami správné zemědělské praxe, bude dodržovat
		platné právní předpisy Evropského společenství a České republiky
		týkající se zemědělské výroby, ochrany půdního fondu a životního
		prostředí. Při zemědělské výrobě musí dodržovat nařízení vlády
		262/2012 Sb. o stanovení zranitelných oblastí a akčním programu
		(nitrátová směrnice) a nařízení vlády 479/2009 Sb. o stanovení
		důsledků porušení podmíněnosti poskytování některých podpor (GAEC).</p>
	<p>4.3 Pachtýř je povinen dbát na minimalizaci vzniku eroze,
		udržovat úrodnost půdy, pravidelně střídat plodiny, v přiměřené míře
		hnojit organickými a minerálními hnojivy a zajišťovat ochranu proti
		přemnožení škůdců a plevelů podle zásad správné agrotechniky a správné
		zemědělské praxe.</p>
	<p>4.4 Pachtýři se zakazuje, aby svou činností poškozoval či
		likvidoval geodetické značky, hranice, přirozené rozhradí, či krajinné
		prvky nalézající se na pozemcích.</p>
	<p>4.5 Pachtýř je povinen propachtovatele na jeho žádost informovat
		o stavu pozemků, zejména o jejich vyhnojení, používání ochranných
		prostředků a stavu eroze.</p>
	<p>4.6 Pachtýři náleží plodiny vzešlé na pozemcích z provozování
		jeho činnosti. Trvalé porosty na pozemcích jsou vlastnictvím
		propachtovatele, pachtýři náleží užitky z trvalých porostů po dobu
		nájmu. Pachtýř nesmí bez souhlasu propachtovatele vysazovat na
		pozemcích trvalé porosty.</p>
	<p>4.7 Běžné opravy pozemků provádí na své náklady pachtýř.
		Případné opravy závad na melioracích jsou považovány za běžnou opravu
		pozemků.</p>
	<p>4.8 Pachtýř se zavazuje po ukončení pachtu předat
		propachtovateli pozemky podmítnuté a nezaseté. Pokud je pachtýř v
		tomto stavu propachtovateli nepředá, je propachtovatel oprávněn
		pozemky do tohoto stavu nechat uvést a pachtýř je povinen uhradit
		propachtovateli náklady vzniklé s uvedením pozemků do tohoto stavu.</p>
	<p>4.9 Tato smlouva se nevztahuje na výkon práva myslivosti na
		pozemcích.</p>

	<h2>5. ZÁVĚREČNÁ USTANOVENÍ</h2>
	<p>5.1 Jakékoli změny či doplňky této smlouvy mohou být prováděny
		pouze formou písemných dodatků podepsaných oběma smluvními stranami.</p>
	<p>5.2 Jednostranná právní konání předvídaná touto smlouvou se
		považují za doručená, pokud byla odeslána a doručena na adresu
		příslušné smluvní strany uvedené v záhlaví této smlouvy, a to 3. den
		po odevzdání zásilky k přepravě, nebo byla prokazatelně doručena druhé
		straně prostřednictvím mailu, či jiným prokazatelným způsobem.</p>
	<p>5.3 Tato smlouva je sepsána ve dvou vyhotoveních, z nichž každá
		strana obdrží po jednom.</p>
	<br> <br> <br>

	<table cellspacing="15" cellpadding="10">
		<tr>
			<td>V ………………………… dne ………… 2014</td>
			<td width="1cm"></td>
			<td>V ………………………… dne ………………2014</td>
		</tr>
		<tr>
			<td>..........................................................</td>
			<td></td>
			<td>..........................................................</td>
		</tr>
		<tr>
			<td>propachtovatel</td>
			<td></td>
			<td>pachtýř</td>
		</tr>
	</table>

</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
