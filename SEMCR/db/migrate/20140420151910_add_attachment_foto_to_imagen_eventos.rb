class AddAttachmentFotoToImagenEventos < ActiveRecord::Migration
  def self.up
    change_table :imagen_eventos do |t|
      t.attachment :foto
    end
  end

  def self.down
    drop_attached_file :imagen_eventos, :foto
  end
end
