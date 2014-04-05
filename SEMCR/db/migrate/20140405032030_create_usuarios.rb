class CreateUsuarios < ActiveRecord::Migration
  def change
    create_table :usuarios do |t|
      t.string :nombre
      t.string :foto
      t.string :username
      t.string :password_digest
      t.string :facebook
      t.string :twitter

      t.timestamps
    end
  end
end
