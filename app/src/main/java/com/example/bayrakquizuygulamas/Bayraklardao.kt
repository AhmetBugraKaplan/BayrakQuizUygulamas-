package com.example.bayrakquizuygulamas

import android.annotation.SuppressLint

class Bayraklardao {

    @SuppressLint("Range")
    fun rastgele5BayrakGetir(vt:DataBaseHelper): ArrayList<Bayraklar>{

        val bayrakListe = ArrayList<Bayraklar>()
        //Veri tabanı üzerinde işlem yapabilmek için yetki ataması yapıyoruz
        val db = vt.writableDatabase
        /* Aşşağıdaki kodla beraber select from bayraklar kısmı ile önce tüm bayraklar tablosu elemanlarını seçiyor
        order by random ile rastgele eleman alıyor lımıt 5 ile rastgele aldığımız eleman sayısını 5 e sabitliyoruz
        */
        val cursor = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null)
        /* Bu kısmın mantığı şöyle ki yukarıda cursor adında bir değişken oluşturup buna 5 adet bayraklar tablosundan
        eleman yerleştirdik. cursor.moveToNext in işlevi şöyle ki : Mesala bayraklar tablosunda id ad resim olmak üzere
        3 kısımdan oluşuyor val bayrak = Bayraklar....
        kısmında id ad ve resim değerini getInt veya getString ile beraber alıyoruz cursormoveToNext ile bu işlemi
        while a 5 e tamamlayana kadar ya da LIMIT 5 olmasaydı farklı bayraklar bitene kadar veyahut sınırlama ne ise
        anladın işte mevzu bu sonrasında nesnenin içine her seferde 1.bayragın tum ozelliklerini atıyor sonra bunu
        listeye ekliyor bunu while döngüsünden çıkana kadar yapıyoruz.^^
        */
        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrak_id"))
            ,cursor.getString(cursor.getColumnIndex("bayrak_ad"))
            ,cursor.getString(cursor.getColumnIndex("bayrak_resim")))
            bayrakListe.add(bayrak)
        }
        return bayrakListe
    }

    @SuppressLint("Range")
    fun rastgele3YanlisSecenekGetir(vt:DataBaseHelper, bayrak_id:Int):ArrayList<Bayraklar>{

        val yanlisCevaplarListe = ArrayList<Bayraklar>()

        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id " +
                "ORDER BY RANDOM() LIMIT 3",null)

        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrak_id"))
            ,cursor.getString(cursor.getColumnIndex("bayrak_ad"))
            ,cursor.getString(cursor.getColumnIndex("bayrak_resim")))
            yanlisCevaplarListe.add(bayrak)
        }
        return yanlisCevaplarListe
    }


}