class CreateImagenesEstablecimientos < ActiveRecord::Migration
  def change
    create_table :imagenes_establecimientos do |t|
      t.string :url
      t.integer :id_establecimiento

      t.timestamps
    end
  end
end
