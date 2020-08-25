package com.lleans.appprofilea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var namaInput : String
    lateinit var emailInput : String
    lateinit var telpInput : String
    lateinit var alamatInput : String
    lateinit var genderInput : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()
        btnsave.setOnClickListener{ validasiInput() }
    }
    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        edtGender.adapter = adapter
    }

    private fun validasiInput() {

        namaInput = edtName.text.toString()
        emailInput = edtEmail.text.toString()
        telpInput = edtTelp.text.toString()
        alamatInput = edtAddress.text.toString()
        genderInput = edtGender.selectedItem.toString()


        when{
            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kososng !!"
            genderInput.equals("Pilih Kelamin") -> Toast.makeText(this, "Kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show()
            emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh kososng !!"
            telpInput.isEmpty() -> edtTelp.error = "No. telepon tidak boleh kososng !!"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kososng !!"
            else -> {
                Toast.makeText(this, "Meload halaman profil", Toast.LENGTH_SHORT).show()
                pindahactivity()
            }
        }
    }

    private fun pindahactivity() {
        val intent = Intent(this, Profilea::class.java)

        intent.putExtra("nama", namaInput)
        intent.putExtra("email", emailInput)
        intent.putExtra("gender", genderInput)
        intent.putExtra("telp", telpInput)
        intent.putExtra("alamat", alamatInput)

        startActivity(intent)
    }
}