package com.example.zap

import java.util.*
import kotlin.collections.ArrayList

object Constants {

    const val USERNAME: String = "user_name"
    const val QUESTIONS_TOTAL: String = "questions_total"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val CATEGORY: String = "category_name"
    const val GENERAL_HIGHEST_SCORE: String = "general_highest_score"
    const val HISTORY_HIGHEST_SCORE: String = "history_highest_score"
    const val MOVIES_HIGHEST_SCORE: String = "movies_highest_score"
    const val COMICS_HIGHEST_SCORE: String = "comics_highest_score"

    //General Questions
    fun generalQuestions(): ArrayList<Question> {
        val generalQuestionsList = ArrayList<Question>()

        val genQuestion1 = Question(1, "Rumah Dhurung merupakan rumah adat yang berasal dari?", "General",
            R.drawable.rumah_dhurung,
            "Pulau Sempu",
            "Pulau Bawean Gresik",
            "Pulau Madura",
            2)
        generalQuestionsList.add(genQuestion1)

        val genQuestion2 = Question(2, "Rumah adat Joglo Sinom merupakan rumah adat dari daerah?", "General",
            R.drawable.rumah_adat_joglo_sinom,
            "Jawa Tengah",
            "Jawan Timur",
            "Jawa Barat",
            2)
        generalQuestionsList.add(genQuestion2)

        val genQuestion3 = Question(3, "Rumah Adat Osing merupakan rumah adat yang berasal dari daerah?", "General",
            R.drawable.rumah_adat_osing,
            "Probolinggo",
            "Gresik",
            "Banyuwangi",
            3)
        generalQuestionsList.add(genQuestion3)

        val genQuestion4 = Question(4, "Rumah bale-bale di Jawa Timur merupakan rumah adat peninggalan suku?", "General",
                R.drawable.rumah_bale_bale,
                "Tengger",
                "Jawa",
                "Dayak",
                1)
        generalQuestionsList.add(genQuestion4)

        Collections.shuffle(generalQuestionsList)
        return generalQuestionsList
    }

    //History Questions
    fun historyQuestions(): ArrayList<Question> {
        val historyQuestionsList = ArrayList<Question>()

        val hisQuestion1 = Question(1, "Alat musik Bonang yang ada di Jawa Timur dimainkan dengan cara?", "History",
                R.drawable.alat_musik_bonang,
                "Ditekan",
                "Digesek",
                "Dipukul",
                3)
        historyQuestionsList.add(hisQuestion1)

        val hisQuestion2 = Question(2, "Alat musik angklung caruk merupakan alat musik angklung yang berasal dari daerah?", "History",
                R.drawable.angklung_caruk,
                "Bayuwangi",
                "Madura",
                "Ponorogo",
                1)
        historyQuestionsList.add(hisQuestion2)

        val hisQuestion3 = Question(3, "Pada gambar di bawah ini alat musik daerah yang berasal dari Jawa Timur yang dimaksud adalah?", "History",
                R.drawable.suling_bambu,
                "Saluang",
                "Suling Bambu",
                "Rinding",
                2)
        historyQuestionsList.add(hisQuestion3)

        val hisQuestion4 = Question(4, "Alat musik daerah Jawa Timur yang ditunjukkan oleh gambar di bawah ini adalah?", "History",
                R.drawable.alat_musik_gendang,
                "Gong",
                "Bonang",
                "Gendang",
                3)
        historyQuestionsList.add(hisQuestion4)

        val hisQuestion5 = Question(5, "Tari reog merupakan tarian khas daerah?", "History",
                R.drawable.reog_ponorogo,
                "Banyuwangi",
                "Madura",
                "Ponorogo",
                3)
        historyQuestionsList.add(hisQuestion5)

        val hisQuestion6 = Question(6, "Tari Kuda Lumping berasal dari daerah ?", "History",
                R.drawable.kuda_lumping,
                "Ponorogo",
                "Banyuwangi",
                "Jombang",
                1)
        historyQuestionsList.add(hisQuestion6)

        val hisQuestion7 = Question(7, "Tari Remo merupakan tarian khas daerah?", "History",
                R.drawable.tari_remo,
                "Banyuwangi",
                "Jombang",
                "Lamongan",
                2)
        historyQuestionsList.add(hisQuestion7)

        val hisQuestion8 = Question(8, "Tari Jaranan Buto merupakan tarian khas daerah?", "History",
                R.drawable.jaranan_buto,
                "Jombang",
                "Ponorogo",
                "Banyuwangi",
                3)
        historyQuestionsList.add(hisQuestion8)

        Collections.shuffle(historyQuestionsList)
        return historyQuestionsList
    }

    //Movies Questions
    fun moviesQuestions(): ArrayList<Question> {
        val moviesQuestionsList = ArrayList<Question>()

        val movQuestion1 = Question(1, "Suku terbesar yang ada di Pulau Jawa Timur adalah suku?", "Movies",
            R.drawable.suku_jawa,
            "Madura",
            "Samin",
            "Jawa",
            3)
        moviesQuestionsList.add(movQuestion1)

        val movQuestion2 = Question(2, "Suku yang ditunjukkan oleh gambar berikut merupakan suku?", "Movies",
            R.drawable.suku_madura,
            "Madura",
            "Jawa",
            "Samin",
            1)
        moviesQuestionsList.add(movQuestion2)

        val movQuestion3 = Question(3, "Suku yang ditunjukkan oleh gambar berikut sebagian besar mendiami wilayah?", "Movies",
            R.drawable.suku_samin,
            "Ponorogo",
            "Malang",
            "Bojonegoro",
            3)
        moviesQuestionsList.add(movQuestion3)

        val movQuestion4 = Question(4, "Suku yang mendiami wilayah pegunungan di Jawa Timur yang ditunjukkan oleh gambar berikut adalah suku?", "Movies",
            R.drawable.suku_tengger,
            "Tengger",
            "Samin",
            "Bawean",
            1)
        moviesQuestionsList.add(movQuestion4)

        val movQuestion5 = Question(5, "Suku yang mendiami daerah Kabupaten Gresik, Jawa Timur yang ditunjukkan oleh gambar di bawah ini adalah?", "Movies",
            R.drawable.suku_bawean,
            "Jawa",
            "Bawean",
            "Samin",
            2)
        moviesQuestionsList.add(movQuestion5)

        val movQuestion6 = Question(6, "Senjata khas dari daerah Jawa Timur yang ditunjukkan oleh gambar di bawah ini adalah?", "Movies",
            R.drawable.keris,
            "Keris",
            "Caluk",
            "Kudi",
            1)
        moviesQuestionsList.add(movQuestion6)

        val movQuestion7 = Question(7, "Senjata khas yang ditunjukkan oleh gambar di bawah ini berasal dari daerah?", "Movies",
            R.drawable.celurit,
            "Banyuwangi",
            "Ponorogo",
            "Madura",
            3)
        moviesQuestionsList.add(movQuestion7)

        val movQuestion8 = Question(8, "Senjata khas Jawa Timur yang ditunjukkan oleh gambar di bawah ini adalah?", "Movies",
            R.drawable.kudi,
            "Bunding",
            "Kudi",
            "Celurit",
            2)
        moviesQuestionsList.add(movQuestion8)

        val movQuestion9 = Question(9, "Senjata yang berasal dari Suku Using Banyuwangi yang digunakan untuk melakukan pekerjaan, mempertahankan diri dari serangan binatang buas, dan ancaman musuh yang ditunjukkan oleh gamabr di bawah ini adalah ?", "Movies",
            R.drawable.bunding,
            "Golok",
            "Caluk",
            "Bunding",
            3)
        moviesQuestionsList.add(movQuestion9)

        val movQuestion10 = Question(10, "Senjata tradisional asal Jawa Timur , tepatnya Kabupaten Tuban yang ditunjukkan oleh gambar di bawah ini adalah?", "Movies",
            R.drawable.caluk,
            "Celurit",
            "Kudi",
            "Caluk",
            3)
        moviesQuestionsList.add(movQuestion10)

        Collections.shuffle(moviesQuestionsList)
        return moviesQuestionsList
    }

    //Comics Questions
    fun comicsQuestions(): ArrayList<Question> {
        val comicsQuestionsList = ArrayList<Question>()

        val comQuestion1 = Question(1, "Pakaian adat Jawa Timur yang biasanya dipakai oleh pengantin yang ditunjukkan oleh gambar adalah pakaian?", "Comics",
            R.drawable.baju_mantenan,
            "Pakaian Cak dan Ning",
            "Baju mantenan",
            "Star Fire",
            2)
        comicsQuestionsList.add(comQuestion1)

        val comQuestion2 = Question(2, "Baju khas daerah Madura yang ditunjukkan oleh gambar diberi nama?", "Comics",
            R.drawable.baju_sakera,
            "Baju Sakera",
            "Baju Pesa'an",
            "Baju Penadhon",
            1)
        comicsQuestionsList.add(comQuestion2)

        val comQuestion3 = Question(3, "Pakaian adat daerah yang ditunjukkan oleh gambar di bawah ini sering disebut sebagai", "Comics",
            R.drawable.pakaian_cak_ning,
            "Baju mantenan",
            "Pakaian Cak dan Ning",
            "Baju pesa'an",
            2)
        comicsQuestionsList.add(comQuestion3)

        val movQuestion4 = Question(4, "Baju Pesa'an yang ditunjukkan oleh gambar di bawah ini berasal dari daerah?", "Comics",
            R.drawable.baju_pesaan,
            "Banyuwangi",
            "Probolinggo",
            "Madura",
            3)
        comicsQuestionsList.add(movQuestion4)

        val comQuestion5 = Question(5, "Baju penadon yang ditunjukkan oleh gambar di bawah ini berasal dari daerah?", "Comics",
            R.drawable.baju_panadhon,
            "Malang",
            "Ponorogo",
            "Surabaya",
            2)
        comicsQuestionsList.add(comQuestion5)

        val comQuestion6 = Question(6, "Rawon adalah adalah salah satu makanan atau hidangan tertua yang ada dalam sejarah Jawa kuno yang berasal dari kerajaan?", "Comics",
            R.drawable.rawon,
            "Mataram",
            "Madapahit",
            "Singasari",
            1)
        comicsQuestionsList.add(comQuestion6)

        val comQuestion7 = Question(7, "Rujak Cingur adalah Makanan Jawa Timur yang berisi berbagai macam jenis sayuran dan buah yang berasal dari daerah?", "Comics",
            R.drawable.rujak_cingur,
            "Surabaya",
            "Madura",
            "Lamongan",
            1)
        comicsQuestionsList.add(comQuestion7)

        val comQuestion8 = Question(8, "Makanan yang ditunjukkan oleh gambar berasal dari daerah?", "Comics",
            R.drawable.soto_lamongan,
            "Malang",
            "Surabaya",
            "Lamongan",
            3)
        comicsQuestionsList.add(comQuestion8)

        val comQuestion9 = Question(9, "Makanan yang ditunjukkan oleh gambar adalah?", "Comics",
            R.drawable.bakso_malang,
            "Rawon",
            "Bakso Malang",
            "Sop",
            2)
        comicsQuestionsList.add(comQuestion9)

        val comQuestion10 = Question(10, "Nasi Krawu merupakan makanan khas dari daerah?", "Comics",
            R.drawable.nasi_krawu,
            "Madura",
            "Surabaya",
            "Gresik",
            3)
        comicsQuestionsList.add(comQuestion10)

        Collections.shuffle(comicsQuestionsList)
        return comicsQuestionsList
    }

    fun generalMateris(): ArrayList<Materi>{
        val generalMaterisList = ArrayList<Materi>()
        val genMateri1 = Materi(1, "Rumah adat Dhurung merupakan rumah adat yang berasal dari daerah Gresik, Jawa Timur.", "General",
            R.drawable.rumah_dhurung)
        generalMaterisList.add(genMateri1)
        val genMateri3 = Materi(2, "Rumah adat Joglo Sinom merupakan rumah adat yang berasal dari daerah Jawa Timur.", "General",
            R.drawable.rumah_adat_joglo_sinom)
        generalMaterisList.add(genMateri3)
        val genMateri4 = Materi(3, "Rumah adat Osing merupakan rumah adat yang berasal dari Banyuwangi, Jawa Timur.", "General",
            R.drawable.rumah_adat_osing)
        generalMaterisList.add(genMateri4)
        val genMateri5 = Materi(4, "Rumah adat Suku Tengger yang memiliki tempat duduk yang disebut Bale-Bale.", "General",
            R.drawable.rumah_bale_bale)
        generalMaterisList.add(genMateri5)
        return generalMaterisList
    }

    fun historyMateris(): ArrayList<Materi>{
        val historyMaterisList = ArrayList<Materi>()
        val hisMateri1 = Materi(1, "Alat musik Bonang yang di ada di Jawa Timur merupakan alat musik daerah yang dimainkan dengan cara dipukul dengan menggunakan wilaga.", "General",
            R.drawable.alat_musik_bonang)
        historyMaterisList.add(hisMateri1)
        val hisMateri2 = Materi(2, "Alat musik angklung caruk merupakan alat musik angklung yang berasal dari Banyuwangi, Jawa Timur.", "General",
            R.drawable.angklung_caruk)
        historyMaterisList.add(hisMateri2)
        val hisMateri3 = Materi(3, "Gendang merupakan alat musik pukul yang umum dijumpai di beberapa daerah di Indonesia, termasuk di Jawa Timur.", "General",
            R.drawable.alat_musik_gendang)
        historyMaterisList.add(hisMateri3)
        val hisMateri4 = Materi(4, "Suling Bambu merupakan alat musik tiup yang berasal dari Jawa Timur yang paling sering dijumpai dalam kehidupan sehari-hari.", "General",
            R.drawable.suling_bambu)
        historyMaterisList.add(hisMateri4)
        val hisMateri5 = Materi(5, "Tari Reog merupakan tarian tradisional yang berasal dari Ponorogo, Jawa Timur.", "General",
            R.drawable.reog_ponorogo)
        historyMaterisList.add(hisMateri5)
        val hisMateri6 = Materi(6, "Tari Kuda Lumping atau Jaran kepang adalah tarian tradisional Jawa yang berasal dari Ponorogo, Jawa Timur.", "General",
            R.drawable.kuda_lumping)
        historyMaterisList.add(hisMateri6)
        val hisMateri7 = Materi(7, "Tari Jaranan Buto adalah salah satu kesenian dari Kabupaten Banyuwangi Provinsi Jawa Timur yang saat ini masih digemari masyarakat Banyuwangi. Tari tersebut menggunakan properti kuda, pecut, celeng dan barongan buto, seperti halnya yang ada pada Kesenian Kuda Lumping, Jaran Kepang atau Tari Jathilan.", "General",
            R.drawable.jaranan_buto)
        historyMaterisList.add(hisMateri7)
        val hisMateri8 = Materi(8, "Tari remo merupakan tarian khas Jawa Timur yang berasal dari Kabupaten Jombang. Tari yang awalnya dihadirkan sebagai pembuka pagelaran seni ludruk dan wayang kulit ini berkembang meluas hampir diseluruh wilayah Jawa Timur.", "General",
            R.drawable.tari_remo)
        historyMaterisList.add(hisMateri8)
        return historyMaterisList
    }

    fun moviesMateris(): ArrayList<Materi>{
        val movieMaterisList = ArrayList<Materi>()
        val movieMateri1 = Materi(1, "Suku terbesar yang ada di Pulau Jawa adalah Suku Jawa.", "General",
            R.drawable.suku_jawa)
        movieMaterisList.add(movieMateri1)
        val movieMateri2 = Materi(2, "Suku Samin merupakan suku yang mendiami wilayah Bojonegoro, Jawa Timur.", "General",
            R.drawable.suku_samin)
        movieMaterisList.add(movieMateri2)
        val movieMateri3 = Materi(3, "Suku Madura merupakan suku yang mendiami wilayah Madura, Jawa Timur.", "General",
            R.drawable.suku_madura)
        movieMaterisList.add(movieMateri3)
        val movieMateri4 = Materi(4, "Suku Tengger merupakan penduduk asli daerah dataran tinggi di sekitar pegunungan Tengger, Bromo, dan Semeru yang terletak di Jawa Timur.", "General",
            R.drawable.suku_tengger)
        movieMaterisList.add(movieMateri4)
        val movieMateri5 = Materi(5, "Suku Bawean merupakan masyarakat yang mendiami Pulau Bawean yaitu Bagian utara Kabupaten Gresik, Jawa Timur.", "General",
            R.drawable.suku_bawean)
        movieMaterisList.add(movieMateri5)
        val movieMateri6 = Materi(6, "Keris merupakan senjata tradisional Jawa Timur yang memiliki ujung lancip serta kedua sisinya tajam.", "General",
            R.drawable.keris)
        movieMaterisList.add(movieMateri6)
        val movieMateri7 = Materi(7, "Celurit merupakan senjata tradisional ini berasal dari Suku Madura. Celurit memiliki tiga kegunaan utama, yakni sebagai senjata peperangan, perlengkapan berkebun dan bertani serta instrumen dalam upacara adat.", "General",
            R.drawable.celurit)
        movieMaterisList.add(movieMateri7)
        val movieMateri8 = Materi(8, "Kudi adalah senjata khas Jawa Timur yang memiliki bentuk mirip dengan senjata Kujang Jawa Barat. Kudi digunakan untuk pekerjaan kasar dan juga pertahanan diri rakyat Jawa Timur.", "General",
            R.drawable.kudi)
        movieMaterisList.add(movieMateri8)
        val movieMateri9 = Materi(9, "Bunding adalah senjata berbentuk pisau besar yang mirip deperti golok dengan sarung yang terbuat dari kayu. Bunding berasal dari Suku Using Banyuwangi yang digunakan untuk melakukan pekerjaan, mempertahankan diri dari serangan binatang buas, dan ancaman musuh.", "General",
            R.drawable.bunding)
        movieMaterisList.add(movieMateri9)
        val movieMateri10 = Materi(10, "Caluk merupakan senjata tradisional asal Jawa Timur , tepatnya Kabupaten Tuban. Caluk berbentuk seperti golok sepanjang 1 meter yang terdapat kapak dibagian tengah bilahnya.", "General",
            R.drawable.caluk)
        movieMaterisList.add(movieMateri10)
        return movieMaterisList
    }

    fun comicsMateris(): ArrayList<Materi>{
        val comicsMaterisList = ArrayList<Materi>()
        val comicsMateri1 = Materi(1, "Pakaian adat Jawa Timur ini khusus digunakan oleh pengantin atau yang dalam bahasa Jawa disebut dengan “manten”. Pakaian ini dikenakan kedua mempelai pada saat melakukan prosesi pernikahan dengan menggunakan adat Jawa Timur. Namun ada pula yang hanya mengadopsi pakaiannya saja, tetapi tidak melakukan prosesi pernikahan dengan lengkap.", "General",
            R.drawable.baju_mantenan)
        comicsMaterisList.add(comicsMateri1)
        val comicsMateri2 = Materi(2, "Baju Sakera merupakan baju khas daerah Madura yang memiliki motif garis-garis merah dan putih, bahannya bisa berupa kaos ataupun kain katun. Pakaian khas pria Madura ini sering dikenakan dalam berbagai acara adat.", "General",
            R.drawable.baju_sakera)
        comicsMaterisList.add(comicsMateri2)
        val comicsMateri3 = Materi(3, "Pakaian Cak dan Ning merupakan Pakaian adat Jawa Timur yang mana dari namanya yakni, Cak merupakan panggilan untuk laki-laki muda. Sedangkan Ning, panggilan untuk perempuan atau gadis.", "General",
            R.drawable.pakaian_cak_ning)
        comicsMaterisList.add(comicsMateri3)
        val comicsMateri4 = Materi(4, "Baju pesa'an adalah baju adat khas dari Madura, provinsi Jawa Timur. Baju Pesa'an menjadi salah satu simbol utama yang menjadi wakil budaya baju adat Jawa Timur di Nusantara. Baju Pesa'an ini bisa digunakan pada acara-acara penting masyarakat Madura seperti acara upacara pernikahan ataupun acara penting lainnya.", "General",
            R.drawable.baju_pesaan)
        comicsMaterisList.add(comicsMateri4)
        val comicsMateri5 = Materi(5, "Penadon adalah baju adat yang berasal dari daerah Ponorogo. Baju ini mirip dengan baju tradisional dari Madura, yaitu baju pe’sean. Akan tetapi ada sedikit perbedaan, yaitu baju penadon ditambahkan gambar reog atau barong sebagai ikon kesenian dari kota Ponorogo.", "General",
            R.drawable.baju_panadhon)
        comicsMaterisList.add(comicsMateri5)
        val comicsMateri6 = Materi(6, "Rawon adalah adalah salah satu makanan atau hidangan tertua yang ada dalam sejarah Jawa kuno yang terkenal berasal dari Surabaya, Jawa Timur. Rawon sudah ada sejak sembilan ratus satu masehi atau lebih tepatnya sudah ada sejak era Kerajaan Mataram.", "General",
            R.drawable.rawon)
        comicsMaterisList.add(comicsMateri6)
        val comicsMateri7 = Materi(7, "Rujak Cingur adalah Makanan khas kota Surabaya, Jawa Timur yang berisi berbagai macam jenis sayuran dan buah. Sayuran dan buah tersebut ada krai, tauge, kangkung, nanas, kacang panjang, kedondong, dan sebagainya.", "General",
            R.drawable.rujak_cingur)
        comicsMaterisList.add(comicsMateri7)
        val comicsMateri8 = Materi(8, "Soto lamongan adalah soto ayam khas kabupaten Lamongan, Jawa Timur, yang saat ini telah menyebar ke berbagai daerah di Indonesia. Soto lamongan dikenal sebagai salah satu soto paling gurih lantaran memiliki ciri khas taburan koya udang yang tidak dimiliki oleh soto lainnya.", "General",
            R.drawable.soto_lamongan)
        comicsMaterisList.add(comicsMateri8)
        val comicsMateri9 = Materi(9, "Bakso Malang adalah hidangan bakso yang banyak ditemui di seluruh belahan Kota Malang dan Kabupaten Malang, Jawa Timur. Mirip dengan hidangan bakso lainnya, hidangan tersebut terdiri dari daging yang dibentuk bundar dan mie. Bedanya ada pada penambahan kulit pangsit yang digoreng dan tahu yang digoreng.", "General",
                R.drawable.bakso_malang)
        comicsMaterisList.add(comicsMateri9)
        val comicsMateri10 = Materi(10, "Nasi Krawu merupakan makanan khas dari daerah Gresik, Jawa Timur. Ciri khasnya adalah nasinya yang pulen dan disajikan dengan daun pisang. Lauknya dapat berupa sayatan daging sapi, semur daging, jeroan sapi, sambal petis dan serundeng.","General",
            R.drawable.nasi_krawu)
        comicsMaterisList.add(comicsMateri10)
        return comicsMaterisList
    }
}