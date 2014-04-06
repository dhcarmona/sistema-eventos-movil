class CreateEstablecimientos < ActiveRecord::Migration
  def change
    create_table :establecimientos do |t|
      t.string :nombre
      t.text :direccion
      t.float :longitud
      t.float :latitud
      t.text :descripcion
      t.integer :usuario_id

      t.timestamps
    end
  end
end
