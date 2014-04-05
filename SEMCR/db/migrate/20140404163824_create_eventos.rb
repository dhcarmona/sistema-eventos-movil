class CreateEventos < ActiveRecord::Migration
  def change
    create_table :eventos do |t|
      t.string :nombre
      t.text :descripcion
      t.integer :establecimiento_id

      t.timestamps
    end
  end
end
