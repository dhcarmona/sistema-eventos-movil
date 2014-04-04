class CreateUsuarios < ActiveRecord::Migration
  def change
    create_table :usuarios do |t|
      t.string :nombre
      t.string :foto
      t.string :contrasena
      t.string :username
      t.string :facebook
      t.string :twitter

      t.timestamps
    end
  end
end
