package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_libro.*

class IngresarLibroActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : Autor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_libro)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<Autor>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        btnGuardar.setOnClickListener { guardarJugador() }
    }

    fun guardarJugador(){
        val jugador = Libro(id = null,
            numeroCamiseta = txtnumeroCamiseta.text.toString().toInt(),
            nombreCamiseta = txtNombreCamiseta.text.toString(),
            nombreCompletoJugador = txtNombreJugador.text.toString(),
            poderEspecialDos = txtpoderEspecialDos.text.toString(),
            fechaIngresoEquipo = txtfechaIngresoEquipo.text.toString(),
            goles = txtGoles.text.toString().toInt(),
            equipoFutbolId = padreId)
        BDLibros.agregarJugador(jugador)
        Toast.makeText(this, "Libro creado exitosamente "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarAutorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}