class CreateImagenEventos < ActiveRecord::Migration
  def change
    create_table :imagen_eventos do |t|
      t.integer :evento_id

      t.timestamps
    end
  end
end
