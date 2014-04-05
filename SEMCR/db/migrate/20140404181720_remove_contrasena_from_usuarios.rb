class RemoveContrasenaFromUsuarios < ActiveRecord::Migration
  def change
    remove_column :usuarios, :contrasena, :string
  end
end
