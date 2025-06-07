package br.com.alunos_rm551188_rm551665

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.Alunos_rm551188_rm551665.R


class IdentificacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identificacao)

        val tvIdentificacao: TextView = findViewById(R.id.tvIdentificacao)
        tvIdentificacao.text = "Participantes:\nEduarda Shiratsu – RM551188\nFelipe Cortez – RM551665"
    }
}
