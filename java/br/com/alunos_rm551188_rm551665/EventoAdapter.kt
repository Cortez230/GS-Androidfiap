package br.com.alunos_rm551188_rm551665

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.Alunos_rm551188_rm551665.R


class EventoAdapter(
    private val listaEventos: List<Evento>,
    private val aoExcluir: (Evento) -> Unit
) : RecyclerView.Adapter<EventoAdapter.ViewHolderEvento>() {

    inner class ViewHolderEvento(view: View) : RecyclerView.ViewHolder(view) {
        val tvLocal: TextView = view.findViewById(R.id.tvLocal)
        val tvTipo: TextView = view.findViewById(R.id.tvTipo)
        val tvGrau: TextView = view.findViewById(R.id.tvGrau)
        val tvData: TextView = view.findViewById(R.id.tvData)
        val tvNumero: TextView = view.findViewById(R.id.tvNumero)
        val btnExcluir: Button = view.findViewById(R.id.btnExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEvento {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return ViewHolderEvento(view)
    }

    override fun onBindViewHolder(holder: ViewHolderEvento, position: Int) {
        val evento = listaEventos[position]
        holder.tvLocal.text = "Local: ${evento.local}"
        holder.tvTipo.text = "Tipo: ${evento.tipo}"
        holder.tvGrau.text = "Impacto: ${evento.grau}"
        holder.tvData.text = "Data: ${evento.data}"
        holder.tvNumero.text = "Afetados: ${evento.numeroAfetados}"

        holder.btnExcluir.setOnClickListener {
            aoExcluir(evento)
        }
    }

    override fun getItemCount() = listaEventos.size
}