class AddAttachmentFotoToUsuarios < ActiveRecord::Migration
  def self.up
    change_table :usuarios do |t|
      t.attachment :foto
    end
  end

  def self.down
    drop_attached_file :usuarios, :foto
  end
end
