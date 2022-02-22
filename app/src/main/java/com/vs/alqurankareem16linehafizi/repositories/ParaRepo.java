package com.vs.alqurankareem16linehafizi.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.vs.alqurankareem16linehafizi.dao.ParaDAO;
import com.vs.alqurankareem16linehafizi.room_database.MyRoomDatabase;
import com.vs.alqurankareem16linehafizi.room_model.ParaRoom;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class ParaRepo {

    private final LiveData<List<ParaRoom>> paraList;
    private static ParaDAO dao;


    public ParaRepo(Application application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.paraDAO();
        paraList = dao.listOfPara();
    }


    public LiveData<List<ParaRoom>> getParaList(){
        return paraList;
    }

    public void insertPara(){
        for (int i=0;i<getList().size();i++){
            ParaRoom obj = getList().get(i);
            dao.insert(obj);
        }
    }

    public void deletePara(ParaRoom paraRoom){
        dao.delete(paraRoom);
    }

    public void updatePara(ParaRoom paraRoom){
        dao.update(paraRoom);
    }

    /*.public LiveData<ParaRoom> getParaByIndex(String indexNumber){
        return dao.getParaByIndex(indexNumber);
    }*/

    /*public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }*/

    public void deleteTableData(){
        dao.deleteCompleteTable();
    }

    private List<ParaRoom> getList(){
        List<ParaRoom> paraList = new ArrayList<>();
        paraList.add(new ParaRoom(1,"1", "2", "Alif Lam Meem", "آلم ","0"));
        paraList.add(new ParaRoom(2,"2", "21", "Sayaqool", "سَيَقُولُ ","0"));
        paraList.add(new ParaRoom(3,"3", "39", "Tilkal Rusull", "تِلْكَ ٱلْرُّسُل ","0"));
        paraList.add(new ParaRoom(4,"4", "57", "Lan Tana Loo'", "لَنْ تَنَالُوا ","0"));
        paraList.add(new ParaRoom(5,"5", "75", "Wal Mohsanat", "وَٱلْمُحْصَنَاتُ ","0"));
        paraList.add(new ParaRoom(6,"6", "93", "La Yuhibbullah", "لَا يُحِبُّ ٱللهُ ","0"));
        paraList.add(new ParaRoom(7,"7", "111", "Wa Iza Samiu", "وَإِذَا سَمِعُوا ","0"));
        paraList.add(new ParaRoom(8,"8", "129", "Wa Lau Annana", "وَلَوْ أَنَّنَا ","0"));
        paraList.add(new ParaRoom(9,"9", "147", "Qalal Malao", "قَالَ ٱلْمَلَأُ ","0"));
        paraList.add(new ParaRoom(10,"10", "165", "Wa A'lamu", "وَٱعْلَمُواْ ","0"));
        paraList.add(new ParaRoom(11,"11", "183", "Yatazeroon", "يَعْتَذِرُونَ ","0"));
        paraList.add(new ParaRoom(12,"12", "201", "Wa Mamin Da'abat", "وَمَا مِنْ دَآبَّةٍ ","0"));
        paraList.add(new ParaRoom(13,"13", "219", "Wa Ma Ubrioo", "وَمَا أُبَرِّئُ ","0"));
        paraList.add(new ParaRoom(14,"14", "237", "Rubama", "رُبَمَا ","0"));
        paraList.add(new ParaRoom(15,"15", "255", "Subhanallazi", "سُبْحَانَ ٱلَّذِى ","0"));
        paraList.add(new ParaRoom(16,"16", "273", "Qal Alam", "قَالَ أَلَمْ ","0"));
        paraList.add(new ParaRoom(17,"17", "291", "Aqtarabo Linnasi", "ٱقْتَرَبَ لِلْنَّاسِ ","0"));

        paraList.add(new ParaRoom(18,"18", "309", "Qadd Aflaha", "قَدْ أَفْلَحَ ","0"));
        paraList.add(new ParaRoom(19,"19", "327", "Wa Qalallazina", "وَقَالَ ٱلَّذِينَ ","0"));
        paraList.add(new ParaRoom(20,"20", "345", "A'man Khalaq", "أَمَّنْ خَلَقَ ","0"));
        paraList.add(new ParaRoom(21,"21", "363", "Utlu Ma Oohi", "اتْلُ مَا أُوحِيَ ","0"));
        paraList.add(new ParaRoom(22,"22", "381", "Wa Manyaqnut", "وَمَنْ يَّقْنُتْ ","0"));
        paraList.add(new ParaRoom(23,"23", "399", "Wa Mali", "وَمَا لِيَ ","0"));
        paraList.add(new ParaRoom(24,"24", "417", "An Nur", "فَمَنْ أَظْلَمُ ","0"));
        paraList.add(new ParaRoom(25,"25", "435", "Elahe Yuruddo", "إِلَيْهِ يُرَدُّ ","0"));
        paraList.add(new ParaRoom(26,"26", "453", "Ha'a Meem", "حم ","0"));
        paraList.add(new ParaRoom(27,"27", "471", "Qala Fama Khatbukum", "قَلَ فَمَا خَطْبُكُم ","0"));
        paraList.add(new ParaRoom(28,"28", "489", "Qadd Sami Allah", "قَدْ سَمِعَ ٱللهُ ","0"));
        paraList.add(new ParaRoom(29,"29", "509", "Tabarakallazi", "تَبَارَكَ ٱلَّذِى ","0"));
        paraList.add(new ParaRoom(30,"30", "529", "Amma Yatasa'aloon", "عَمَّ يَتَسَاءَلُونََّ ","0"));
        return paraList;
    }

}
