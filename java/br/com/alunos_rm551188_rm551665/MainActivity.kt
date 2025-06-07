package br.com.alunos_rm551188_rm551665

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.Alunos_rm551188_rm551665.R


class MainActivity : AppCompatActivity() {
    private lateinit var etLocal: EditText
    private lateinit var etTipoEvento: EditText
    private lateinit var etGrauImpacto: EditText
    private lateinit var etData: EditText
    private lateinit var etNumero: EditText
    private lateinit var btnIncluir: Button
    private lateinit var btnIdentificacao: Button
    private lateinit var recyclerView: RecyclerView

    private val eventos = mutableListOf<Evento>()
    private lateinit var eventoAdapter: EventoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLocal = findViewById(R.id.etLocal)
        etTipoEvento = findViewById(R.id.etTipoEvento)
        etGrauImpacto = findViewById(R.id.etGrauImpacto)
        etData = findViewById(R.id.etData)
        etNumero = findViewById(R.id.etNumero)
        btnIncluir = findViewById(R.id.btnIncluir)
        btnIdentificacao = findViewById(R.id.btnIdentificacao)
        recyclerView = findViewById(R.id.recyclerView)

        eventoAdapter = EventoAdapter(eventos) { eventoRemovido ->
            eventos.remove(eventoRemovido)
            eventoAdapter.notifyDataSetChanged()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = eventoAdapter

        btnIncluir.setOnClickListener { adicionarEvento() }
        btnIdentificacao.setOnClickListener {
            startActivity(Intent(this, IdentificacaoActivity::class.java))
        }
    }

    private fun adicionarEvento() {
        val local = etLocal.text.toString().trim()
        val tipo = etTipoEvento.text.toString().trim()
        val grau = etGrauImpacto.text.toString().trim()
        val data = etData.text.toString().trim()
        val numeroStr = etNumero.text.toString().trim()

        if (local.isEmpty() || tipo.isEmpty() || grau.isEmpty() || data.isEmpty() || numeroStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val numeroAfetados = numeroStr.toIntOrNull()
        if (numeroAfetados == null || numeroAfetados <= 0) {
            Toast.makeText(this, "Número de pessoas deve ser maior que 0.", Toast.LENGTH_SHORT).show()
            return
        }

        val novoEvento = Evento(local, tipo, grau, data, numeroAfetados)
        eventos.add(novoEvento)
        eventoAdapter.notifyDataSetChanged()
        limparCampos()
    }

    private fun limparCampos() {
        etLocal.text.clear()
        etTipoEvento.text.clear()
        etGrauImpacto.text.clear()
        etData.text.clear()
        etNumero.text.clear()
    }
}