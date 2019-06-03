package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar_libro.*

class ActualizarLibroActivity : AppCompatActivity() {
    var id :Int = 0;
    var idPadre :Int = 0
    var usuario :String = "";
    var equipoRespaldo : Autor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_libro)
        usuario = intent.getStringExtra("usuario").toString()
        val libroRecibido = intent.getParcelableExtra<Libro>("Libro")
        equipoRespaldo = intent.getParcelableExtra<Autor>("EquipoRespaldo")
        txtICBN.setText(libroRecibido.ICBN.toString())
        txtNombreLibro.setText(libroRecibido.nombreLibro.toString())
        txtEditorial.setText(libroRecibido.numeroPaginas.toString())
        txtnumEdicion.setText(libroRecibido.editorial.toString())
        txtfechaPublicacion.setText(libroRecibido.fechaNacimiento.toString())
        txtNumPaginas.setText(libroRecibido.numEdicion.toString())
        id = libroRecibido.id.toString().toInt()
        idPadre = libroRecibido.autorId.toString().toInt()
        btnActualizarJugador.setOnClickListener { actualizarJugador() }
        btnEliminarJugador.setOnClickListener { eliminarJugador() }
    }

    fun actualizarJugador(){
        val jugador = Libro(id = id,
            ICBN = txtICBN.text.toString().toInt(),
            nombreLibro = txtNombreLibro.text.toString(),
            numeroPaginas = txtEditorial.text.toString(),
            editorial = txtnumEdicion.text.toString(),
            fechaNacimiento = txtfechaPublicacion.text.toString(),
            numEdicion = txtNumPaginas.text.toString().toInt(),
            autorId = idPadre)
        BDLibros.actualizarJugador(jugador)
        Toast.makeText(this, "Actualización jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarAutorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }

    fun eliminarJugador(){
        BDLibros.eliminarJugador(id)
        Toast.makeText(this, "Eliminación jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarAutorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
