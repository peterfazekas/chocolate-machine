<h1>Chocolate machine - Automata</h2>
<h2>Informatika érettségi emelt szintű feladat: 2009. május</h2>
<p>A Csokibolt Kft. a város több pontján üzemeltet csokoládé-automatát. Az automatákból sokféle csokoládét lehet vásárolni pénzérmék bedobásával. A vásárláshoz az 1, 2, 5, 10, 20, 50 és 100 fabatkás érmék használhatók. Egyszerre csak egyfajta csokoládé vásárolható. A vásárlás során először ki kell választani a csokoládét, majd be kell állítani a kívánt darabszámot, végül be kell dobni a pénzt. Ha a szükségesnél több pénzt dobnak be, a gép a csokoládé mellett kiadja a visszajárót is. Amennyiben az automatában már nincs a kívánt darabszámú csokoládé, vagy a bedobott összeg nem elegendő, a vásárlás meghiúsul.</p>
<p>Az egyik automatában árult csokoládék lényeges adatait a <em>csoki.txt</em> állomány tartalmazza. Első sorában az automata rekeszeinek száma (legfeljebb 100) található. A második sortól kezdve soronként három szám, egy-egy rekesz adatsora olvasható. Az első szám a rekesz sorszáma, a második a rekeszben található csokoládé darabszáma, a harmadik pedig az egységára. Egy-egy rekeszben legfeljebb 100 szelet fér el, egy szelet ára legfeljebb 300 fabatka. A rekeszek sorszámozása 1-től kezdődik és folyamatos.</p>
<p>A vásárlások adatai a <em>vasarlas.txt</em> állományban olvashatók. Az első sorban a vásárlások száma, legfeljebb 100 olvasható. A továbbiakban soronként 9 szám szerepel, ami egy vásárlás adatait jelenti az alábbiak szerint: az első szám a választott rekesz sorszáma, a második a kívánt darabszám, utána pedig az következik, hogy az egyes címletekből hány darabot dobtak a gépbe. Az első az 1 fabatkás, a többi növekvően szerepel mögötte, így az utolsó a 100 fabatkás. Az állományban egyetlen szám sem nagyobb 100-nál.</p>
<p>Például: <em>csoki.txt</em>
<pre>
23
1 23 76
2 8 111
3 0 0
…
</pre>
<p>Az 3. sor megmutatja, hogy a 2. rekeszben 8 csokoládé van, amelynek darabja 111 fabatka.</p>
<p><em>vasarlas.txt</em></p>
<pre>
19
2 3 1 1 0 1 1 0 3
2 6 0 0 0 0 0 0 7
1 2 2 0 0 0 0 0 2
…
</pre>
<p>A 3. sor megmutatja, hogy a második vásárló a 2. rekeszből 6 csokoládét választott, 7 darab 100 fabatkás érmét dobott az automatába és más címletű pénzt nem.</p>
<p>Készítsen programot, amely az alábbi kérdésekre válaszol! A program forráskódját <em><b>automata</b></em> néven mentse!</p>
<p>Minden részfeladat megoldása előtt írja a képernyőre a feladat sorszámát! Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár (például a 4. feladat esetén: „<code>4. feladat Kérem a pénzösszeget!</code>”)! Az ékezetmentes kiírás is elfogadott.</p>
<ol>
<li>Olvassa be a <em>csoki.txt</em> és a <em>vasarlas.txt</em> állományban talált adatokat, s azok felhasználásával oldja meg a következő feladatokat! Ha az állományokat nem tudja beolvasni, az állományok első 8 sorának adatait jegyezze be a programba és dolgozzon azzal!</li>
<li>Milyen értékben van csokoládé az automatában? Írja képernyőre a választ a következőhöz hasonló formában: „<code>Az automatában 24817 fabatka értékű csokoládé van.</code>”!</li>
<li>Írja a képernyőre, hogy mely rekeszekből próbáltak csokoládét vásárolni! Minden rekesz sorszámát csak egyszer jelenítse meg! A számokat egymástól szóközzel elválasztva tüntesse fel!</li>
<li>Anna magának és barátainak összesen 7 egyforma csokoládét szeretne vásárolni. Kérje be a csokoládéra szánt pénzösszeget! Írja a képernyőre azon rekeszek sorszámát, amelyek közül választhat! A rekeszek sorszámát szóközökkel válassza el egymástól!</li>
<li>Okos Péter szeret mindenütt pontosan annyi pénzt átadni, amennyi a fizetendő összeg. Ezen túl szeret úgy fizetni, hogy a lehető legkevesebb pénzérmét, bankjegyet kelljen átadnia. Kérje be egy rekesz sorszámát és a darabszámot, majd írja ki, hogy a felhasznált pénzérmékből címletenként hány darabot kell bedobnia Péternek! Csak a felhasznált címleteket adja meg! Egy sorba egy címlet kerüljön; először a címlet értéke, majd mögötte a darabszám jelenjen meg! Nem kell vizsgálnia, hogy van-e elég csokoládé a rekeszben! A megoldás során segítségként a következő algoritmust használhatja: <em>Keresse meg a legnagyobb címletet, amely nem haladja meg a fizetendő összeget! Ebből a címletből kell egyet használnia! A fizetendőt csökkentse a címlet értékével, majd kezdje elölről az algoritmust, ha az nem nulla!</em> Ez az algoritmus a feladatban szereplő címletek esetén működik, de létezhet olyan címletlista, amelynél nem alkalmazható.</li>
<li>Írja a <em>rekesz7.txt</em> állományba, hogy hányas sorszámú vásárlások során hány darabot vettek a 7-es rekeszből! Vegye figyelembe, hogy minden sikeres vásárlással csökken a rekeszben lévő csokoládék száma! Soronként egy vásárlási próbálkozást tüntessen fel! A sor elején a vásárlási próbálkozás sorszáma jelenjen meg, tőle tabulátorral (ASCII kódja a 9-es) elválasztva pedig a vásárlás eredménye legyen olvasható! Az eredmény sikeres vásárlás esetén a darabszám. Ha nem volt megadott mennyiségnek megfelelő csokoládé, akkor a sorszám mögé a „<code>kevés a csoki</code>” üzenet kerüljön! Ha a vásárló által bedobott pénzösszeg kevés, akkor a „<code>nem volt elég pénz</code>” szöveget írja a fájlba! Amennyiben a vásárlás több okból is meghiúsulhat, elegendő csak az egyik okot megjeleníteni.</li>
</ol>
<hr>
<h3>Források:</h3>
<li><a href="https://www.oktatas.hu/pub_bin/dload/kozoktatas/erettsegi/feladatok2009tavasz/e_infomagy_09maj_fl.pdf">Feladatlap</a>
<li><a href="https://www.oktatas.hu/pub_bin/dload/kozoktatas/erettsegi/feladatok2009tavasz/e_infoformagy_09maj_fl.zip">Forrásállományok</a>