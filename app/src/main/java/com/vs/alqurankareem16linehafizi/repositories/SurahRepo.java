package com.vs.alqurankareem16linehafizi.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.vs.alqurankareem16linehafizi.dao.SurahDAO;
import com.vs.alqurankareem16linehafizi.room_database.MyRoomDatabase;
import com.vs.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class SurahRepo {


    private final LiveData<List<SurahRoom>> surahList;
    private static SurahDAO dao;


    public SurahRepo(Application application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.surahDAO();
        surahList = dao.listOfSurah();
    }


    public LiveData<List<SurahRoom>> getSurahList(){

        return surahList;
    }

    public void insertSurah(){
        for (int i=0;i<getList().size();i++){
            SurahRoom obj = getList().get(i);
            dao.insert(obj);
        }
    }

    /*.public void deleteSurah(SurahRoom surahRoom){
        dao.delete(surahRoom);
    }

    public void updateSurah(SurahRoom surahRoom){
        dao.update(surahRoom);
    }*/

   /*. public LiveData<SurahRoom> getSurahByIndex(String indexNumber){
        return dao.getSurahByIndex(indexNumber);
    }*/

    public void deleteTableData(){
        dao.deleteCompleteTable();
    }



    private List<SurahRoom> getList(){
        List<SurahRoom> surahList = new ArrayList<>();
        surahList.add(new SurahRoom(1,"1", "2", "Al-Fatihah (the Opening)", "سُوْرَۃُ الفَاتِحَة","0"));
        surahList.add(new SurahRoom(2,"2", "3", "Al-Baqarah (the Cow)", "سُوْرَۃُ البَقَرَة","0"));
        surahList.add(new SurahRoom(3,"3", "46", "Aali Imran (the Family of Imran)", "سُوْرَۃ آلِ عِمْرَان","0"));
        surahList.add(new SurahRoom(4,"4", "70", "An-Nisa’ (the Women)", "سُوْرَۃُ النِّسَاءِ","0"));
        surahList.add(new SurahRoom(5,"5", "97", "Al-Ma’idah (the Table)","سُوْرَۃُ المَائِدَة","0"));
        surahList.add(new SurahRoom(6,"6", "116", "Al-An’am (the Cattle)", "سُوْرَۃُ الأَنْعَام","0"));
        surahList.add(new SurahRoom(7,"7", "137", "Al-A’raf (the Heights)", "سُوْرَۃُ الأَعْرَاف","0"));
        surahList.add(new SurahRoom(8,"8", "160", "Al-Anfal (the Spoils of War)", "سُوْرَۃُ الأَنْفَال","0"));
        surahList.add(new SurahRoom(9,"9", "169", "At-Taubah (the Repentance)", "سُوْرَۃُ التَّوْبَة","0"));
        surahList.add(new SurahRoom(10,"10", "188", "Yunus (Jonah)", "سُوْرَۃ يُونُس","0"));
        surahList.add(new SurahRoom(11,"11", "200", "Hud (Hud)", "سُوْرَۃ هُود","0"));
        surahList.add(new SurahRoom(12,"12", "213", "Yusuf (Joseph)", "سُوْرَۃ يُوسُف","0"));
        surahList.add(new SurahRoom(13,"13", "225", "Ar-Ra’d (the Thunder)", "سُوْرَۃ الرَّعْد","0"));
        surahList.add(new SurahRoom(14,"14", "231", "Ibrahim (Ibrahim)", "سُوْرَۃُ إِبْرَاهِيم","0"));
        surahList.add(new SurahRoom(15,"15", "236", "Al-Hijr (the Rocky Tract)", "سُوْرَۃُ الحِجْر","0"));
        surahList.add(new SurahRoom(16,"16", "241", "An-Nahl (the Bees)", "سُوْرَۃُ النَّحْل","0"));
        surahList.add(new SurahRoom(17,"17", "255", "Al-Isra’ (the Night Journey)", "سُوْرَۃُ الإِسْرَاء","0"));
        surahList.add(new SurahRoom(18,"18", "265", "Al-Kahf (the Cave)", "سُوْرَۃ الكَهْف","0"));
        surahList.add(new SurahRoom(19,"19", "276", "Maryam (Maryam)", "سُوْرَۃ مَرْيَم","0"));
        surahList.add(new SurahRoom(20,"20", "282", "Ta-Ha (Ta-Ha)", "سُوْرَۃ طٰهٰ","0"));
        surahList.add(new SurahRoom(21,"21", "291", "Al-Anbiya’ (the Prophets)", "سُوْرَۃُ الأَنْبِيَاء","0"));
        surahList.add(new SurahRoom(22,"22", "300", "Al-Haj (the Pilgrimage)", "سُوْرَۃ الحَجّ","0"));
        surahList.add(new SurahRoom(23,"23", "309", "Al-Mu’minun (the Believers)", "سُوْرَۃُ المُؤْمِنُون","0"));
        surahList.add(new SurahRoom(24,"24", "316", "An-Nur (the Light)", "سُوْرَۃ النُّور","0"));
        surahList.add(new SurahRoom(25,"25", "325", "Al-Furqan (the Criterion)", "سُوْرَۃ الفُرْقَان","0"));
        surahList.add(new SurahRoom(26,"26", "331", "Ash-Shu’ara’ (the Poets)", "سُوْرَۃُ الشُّعَرَاء","0"));
        surahList.add(new SurahRoom(27,"27", "340", "An-Naml (the Ants)", "سُوْرَۃُ النَّمْل","0"));
        surahList.add(new SurahRoom(28,"28", "348", "Al-Qasas (the Stories)", "سُوْرَۃُ القَصَص","0"));
        surahList.add(new SurahRoom(29,"29", "358", "Al-Ankabut (the Spider)", "سُوْرَۃُ العَنْكَبُوت","0"));
        surahList.add(new SurahRoom(30,"30", "365", "Ar-Rum (the Romans)", "سُوْرَۃ الرُّوم","0"));

        surahList.add(new SurahRoom(31,"31", "371", "Luqman (Luqman)", "سُوْرَۃ لُقْمَان","0"));
        surahList.add(new SurahRoom(32,"32", "374", "As-Sajdah (the Prostration)", "سُوْرَۃُ السَّجْدَة","0"));
        surahList.add(new SurahRoom(33,"33", "377", "Al-Ahzab (the Combined Forces)", "سُوْرَۃُ الأَحْزَاب","0"));
        surahList.add(new SurahRoom(34,"34", "386", "Saba’ (the Sabeans)", "سُوْرَۃ سَبَأ","0"));
        surahList.add(new SurahRoom(35,"35", "392", "Al-Fatir (the Originator)", "سُوْرَۃ فَاطِر","0"));
        surahList.add(new SurahRoom(36,"36", "397", "Ya-Sin (Ya-Sin)", "سُوْرَۃ يٰس","0"));
        surahList.add(new SurahRoom(37,"37", "402", "As-Saffah (Those Ranges in Ranks)", "سُوْرَۃُ الصَّافَّات","0"));
        surahList.add(new SurahRoom(38,"38", "409", "Sad (Sad)", "سُوْرَۃ ص","0"));
        surahList.add(new SurahRoom(39,"39", "413", "Az-Zumar (the Groups)", "سُوْرَۃُ الزُّمَر","0"));
        surahList.add(new SurahRoom(40,"40", "421", "Ghafar (the Forgiver)", "سُوْرَۃ غَافِر","0"));
        surahList.add(new SurahRoom(41,"41", "430", "Fusilat (Distinguished)", "سُوْرَۃ فُصِّلَت","0"));
        surahList.add(new SurahRoom(42,"42", "435", "Ash-Shura (the Consultation)", "سُوْرَۃُ الشُّورىٰ","0"));
        surahList.add(new SurahRoom(43,"43", "441", "Az-Zukhruf (the Gold)", "سُوْرَۃُ الزُّخْرُف","0"));
        surahList.add(new SurahRoom(44,"44", "447", "Ad-Dukhan (the Smoke)", "سُوْرَۃ الدُّخَان","0"));
        surahList.add(new SurahRoom(45,"45", "449", "Al-Jathiyah (the Kneeling)", "سُوْرَۃ الجَاثِيَة","0"));
        surahList.add(new SurahRoom(46,"46", "453", "Al-Ahqaf (the Valley)", "سُوْرَۃُ الأَحْقَاف","0"));
        surahList.add(new SurahRoom(47,"47", "457", "Muhammad (Muhammad)", "سُوْرَۃ مُحَمَّد","0"));
        surahList.add(new SurahRoom(48,"48", "461", "Al-Fat’h (the Victory)", "سُوْرَۃُ الفَتْح","0"));
        surahList.add(new SurahRoom(49,"49", "464", "Al-Hujurat (the Dwellings)", "سُوْرَۃُ الحُجُرَات","0"));
        surahList.add(new SurahRoom(50,"50", "467", "Qaf (Qaf)", "سُوْرَۃ ق","0"));
        surahList.add(new SurahRoom(51,"51", "469", "Adz-Dzariyah (the Scatterers)", "سُوْرَۃُ الذَّارِيَات","0"));
        surahList.add(new SurahRoom(52,"52", "472", "At-Tur (the Mount)", "سُوْرَۃ الطُّور","0"));
        surahList.add(new SurahRoom(53,"53", "474", "An-Najm (the Star)", "سُوْرَۃُ النَّجْم","0"));
        surahList.add(new SurahRoom(54,"54", "476", "Al-Qamar (the Moon)", "سُوْرَۃُ القَمَر","0"));
        surahList.add(new SurahRoom(55,"55", "479", "Ar-Rahman (the Most Gracious)", "سُوْرَۃ الرَّحْمَٰن","0"));
        surahList.add(new SurahRoom(56,"56", "482", "Al-Waqi’ah (the Event)", "سُوْرَۃُ الوَاقِعَة","0"));
        surahList.add(new SurahRoom(57,"57", "485", "Al-Hadid (the Iron)", "سُوْرَۃُ الحَدِيد","0"));
        surahList.add(new SurahRoom(58,"58", "489", "Al-Mujadilah (the Reasoning)", "سُوْرَۃُ المُجَادِلَة","0"));
        surahList.add(new SurahRoom(59,"59", "492", "Al-Hashr (the Gathering)", "سُوْرَۃُ الحَشْر","0"));
        surahList.add(new SurahRoom(60,"60", "496", "Al-Mumtahanah (the Tested)", "سُوْرَۃُ المُمْتَحَنَة","0"));

        surahList.add(new SurahRoom(61,"61", "498", "As-Saf (the Row)", "سُوْرَۃُ الصَّفّ","0"));
        surahList.add(new SurahRoom(62,"62", "500", "Al-Jum’ah (Friday)", "سُوْرَۃُ الجُمُعَة","0"));
        surahList.add(new SurahRoom(63,"63", "501", "Al-Munafiqun (the Hypocrites)", "سُوْرَۃُ المُنَافِقُون","0"));
        surahList.add(new SurahRoom(64,"64", "503", "At-Taghabun (the Loss & Gain)", "سُوْرَۃُ التَّغَابُن","0"));
        surahList.add(new SurahRoom(65,"65", "505", "At-Talaq (the Divorce)", "سُوْرَۃُ الطَّلَاق","0"));
        surahList.add(new SurahRoom(66,"66", "507", "At-Tahrim (the Prohibition)", "سُوْرَۃُ التَّحْرِيم","0"));
        surahList.add(new SurahRoom(67,"67", "509", "Al-Mulk – (the Kingdom)", "سُوْرَۃُ المُلْك","0"));


        surahList.add(new SurahRoom(68,"68", "5011", "Al-Qalam (the Pen)", "سُوْرَۃ القَلَم","0"));
        surahList.add(new SurahRoom(69,"69", "513", "Al-Haqqah (the Inevitable)", "سُوْرَۃ الحَاقَّة","0"));
        surahList.add(new SurahRoom(70,"70", "515", "Al-Ma’arij (the Elevated Passages)", "سُوْرَۃُ المَعَارِج","0"));
        surahList.add(new SurahRoom(71,"71", "517", "Nuh (Nuh)", "سُوْرَۃ نُوح","0"));
        surahList.add(new SurahRoom(72,"72", "519", "Al-Jinn (the Jinn)", "سُوْرَۃُ الجِنّ","0"));
        surahList.add(new SurahRoom(73,"73", "521", "Al-Muzammil (the Wrapped)", "سُوْرَۃُ المُزَّمِّل","0"));
        surahList.add(new SurahRoom(74,"74", "522", "Al-Mudaththir (the Cloaked)", "سُوْرَۃُ المُدَّثِّر","0"));
        surahList.add(new SurahRoom(75,"75", "524", "Al-Qiyamah (the Resurrection)", "سُوْرَۃُ القِيَامَة","0"));
        surahList.add(new SurahRoom(76,"76", "525", "Al-Insan (the Human)", "سُوْرَۃُ الإِنْسَان","0"));
        surahList.add(new SurahRoom(77,"77", "527", "Al-Mursalat (Those Sent Forth)", "سُوْرَۃُ المُرْسَلَات","0"));
        surahList.add(new SurahRoom(78,"78", "529", "An-Naba’ (the Great News)", "سُوْرَۃُ النَّبَأ","0"));
        surahList.add(new SurahRoom(79,"79", "530", "An-Nazi’at (Those Who Pull Out)", "سُوْرَۃُ النَّازِعَات","0"));
        surahList.add(new SurahRoom(70,"80", "531", "Abasa (He Frowned)", "سُوْرَۃ عَبَسَ","0"));
        surahList.add(new SurahRoom(81,"81", "533", "At-Takwir (the Overthrowing)", "سُوْرَۃُ التَّكْوِير","0"));
        surahList.add(new SurahRoom(82,"82", "533", "Al-Infitar (the Cleaving)", "سُوْرَۃُ الإِنْفِطَار","0"));
        surahList.add(new SurahRoom(83,"83", "534", "Al-Mutaffifin (Those Who Deal in Fraud)", "سُوْرَۃُ المُطَفِّفِين","0"));
        surahList.add(new SurahRoom(84,"84", "535", "Al-Inshiqaq (the Splitting Asunder)", "سُوْرَۃُ الإِنْشِقَاق","0"));
        surahList.add(new SurahRoom(85,"85", "536", "Al-Buruj (the Stars)", "سُوْرَۃُ البُرُوج","0"));
        surahList.add(new SurahRoom(86,"86", "537", "At-Tariq (the Nightcomer)", "سُوْرَۃُ الطَّارِق","0"));
        surahList.add(new SurahRoom(87,"87", "538", "Al-A’la (the Most High)", "سُوْرَۃُ الأَعْلَىٰ","0"));
        surahList.add(new SurahRoom(88,"88", "538", "Al-Ghashiyah (the Overwhelming)", "سُوْرَۃُ الغَاشِيَة","0"));
        surahList.add(new SurahRoom(89,"89", "539", "Al-Fajr (the Dawn)", "سُوْرَۃُ الفَجْر","0"));
        surahList.add(new SurahRoom(90,"90", "540", "Al-Balad (the City)", "سُوْرَۃُ البَلَد","0"));

        surahList.add(new SurahRoom(91,"91", "541", "Ash-Shams (the Sun)", "سُوْرَۃُ الشَّمْس","0"));
        surahList.add(new SurahRoom(92,"92", "541", "Al-Layl (the Night)", "سُوْرَۃُ اللَّيْل","0"));
        surahList.add(new SurahRoom(93,"93", "542", "Adh-Dhuha (the Forenoon)", "سُوْرَۃُ الضُّحَىٰ","0"));
        surahList.add(new SurahRoom(94,"94", "542", "Al-Inshirah (the Opening Forth)", "سُوْرَۃُ الشَّرْح","0"));
        surahList.add(new SurahRoom(95,"95", "543", "At-Tin (the Fig)", "سُوْرَۃُ التِّين","0"));
        surahList.add(new SurahRoom(96,"96", "543", "Al-‘Alaq (the Clot)", "سُوْرَۃُ العَلَق","0"));
        surahList.add(new SurahRoom(97,"97", "544", "Al-Qadar (the Night of Decree)", "سُوْرَۃُ القَدْر","0"));
        surahList.add(new SurahRoom(98,"98", "544", "Al-Bayinah (the Proof)", "سُوْرَۃُ البَيِّنَة","0"));
        surahList.add(new SurahRoom(99,"99", "545", "Az-Zalzalah (the Earthquake)", "سُوْرَۃُ الزَّلْزَلَة","0"));
        surahList.add(new SurahRoom(100,"100", "545", "Al-‘Adiyah (the Runners)", "سُوْرَۃُ العَادِيَات","0"));
        surahList.add(new SurahRoom(101,"101", "545", "Al-Qari’ah (the Striking Hour)", "سُوْرَۃُ القَارِعَة","0"));
        surahList.add(new SurahRoom(102,"102", "546", "At-Takathur (the Piling Up)", "سُوْرَۃُ التَّكَاثُر","0"));
        surahList.add(new SurahRoom(103,"103", "546", "Al-‘Asr (the Time)", "سُوْرَۃُ العَصْر","0"));
        surahList.add(new SurahRoom(104,"104", "546", "Al-Humazah (the Slanderer)", "سُوْرَۃُ الهُمَزَة","0"));
        surahList.add(new SurahRoom(105,"105", "547", "Al-Fil (the Elephant)", "سُوْرَۃُ الفِيل","0"));
        surahList.add(new SurahRoom(106,"106", "547", "Quraish (Quraish)", "سُوْرَۃ قُرَيْش","0"));
        surahList.add(new SurahRoom(107,"107", "547", "Al-Ma’un (the Assistance)", "سُوْرَۃُ المَاعُون","0"));
        surahList.add(new SurahRoom(108,"108", "547", "Al-Kauthar (the River of Abundance)", "سُوْرَۃُ الكَوْثَر","0"));
        surahList.add(new SurahRoom(109,"109", "548", "Al-Kafirun (the Disbelievers)", "سُوْرَۃُ الكَافِرُون","0"));
        surahList.add(new SurahRoom(110,"110", "548", "An-Nasr (the Help)", "سُوْرَۃُ النَّصْر","0"));
        surahList.add(new SurahRoom(111,"111", "548", "Al-Masad (the Palm Fiber)", "سُوْرَۃُ المَسَد","0"));
        surahList.add(new SurahRoom(112,"112", "548", "Al-Ikhlas (the Sincerity)", "سُوْرَۃُ الإِخْلَاص","0"));
        surahList.add(new SurahRoom(113,"113", "549", "Al-Falaq (the Daybreak)", "سُوْرَۃُ الفَلَق","0"));
        surahList.add(new SurahRoom(114,"114", "549", "An-Nas (Mankind)", "سُوْرَۃُ النَّاس","0"));
        return surahList;
    }

    /*.public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }*/



}
