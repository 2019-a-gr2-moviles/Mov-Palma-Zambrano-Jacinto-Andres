package com.example.dr.examen_primerbimestre


class Autor(val id:String,
            val nombres:String,
            val apellidos:String,
            val fechaNacimiento:String,
            val numeroLibros:Int,
            val ecuatoriano:String)


//Parcelable{
/*
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "NOMBRES: ${nombres} APELLIDOS: ${apellidos} FECHA NACIMIENTO: ${fechaNacimiento} " +
                "NUMERO LIBROS:${numeroLibros} ECUATORIANO:${ecuatoriano}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombres)
        parcel.writeString(apellidos)
        parcel.writeString(fechaNacimiento)
        parcel.writeInt(numeroLibros)
        parcel.writeString(ecuatoriano)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Autor> {
        override fun createFromParcel(parcel: Parcel): Autor {
            return Autor(parcel)
        }

        override fun newArray(size: Int): Array<Autor?> {
            return arrayOfNulls(size)
        }
    }*/
