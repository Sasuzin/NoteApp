package br.senac.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.databinding.ActivityNewNoteBinding
import br.senac.noteapp.model.Note

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            inserirNota()
        }
    }

    fun inserirNota()  {
        //1 - Criar uma Instancia do Room.

        val db = Room.databaseBuilder(this, br.senac.noteapp.db.Database::class.java, "notes").build()

        //2 - Carregar os parametros (se tiver).
        val nota = Note(title = binding.etTitle.text.toString(), desc = binding.etDesc.text.toString())

        //3 - Obter e executar a funçao DAO.
        Thread{
            db.NoteDao().inserir(nota)
            finish()
        }.start()


    }

}