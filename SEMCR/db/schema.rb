# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20140420151910) do

  create_table "est_comentarios", force: true do |t|
    t.text     "descripcion"
    t.integer  "usuario_id"
    t.integer  "establecimiento_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "establecimientos", force: true do |t|
    t.string   "nombre"
    t.text     "direccion"
    t.float    "longitud"
    t.float    "latitud"
    t.text     "descripcion"
    t.integer  "usuario_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "foto_file_name"
    t.string   "foto_content_type"
    t.integer  "foto_file_size"
    t.datetime "foto_updated_at"
  end

  create_table "ev_comentarios", force: true do |t|
    t.text     "descripcion"
    t.integer  "usuario_id"
    t.integer  "evento_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "eventos", force: true do |t|
    t.string   "nombre"
    t.text     "descripcion"
    t.integer  "establecimiento_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.datetime "horario"
  end

  create_table "eventos_tipos_{:id=>false}", id: false, force: true do |t|
    t.integer "eventos_tipo_id", null: false
    t.integer "{:id=>false}_id", null: false
    t.integer "evento_id",       null: false
    t.integer "tipo_id",         null: false
  end

  create_table "horarios", force: true do |t|
    t.datetime "fecha"
    t.integer  "evento_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "imagen_eventos", force: true do |t|
    t.integer  "evento_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "foto_file_name"
    t.string   "foto_content_type"
    t.integer  "foto_file_size"
    t.datetime "foto_updated_at"
  end

  create_table "imagenes_establecimientos", force: true do |t|
    t.string   "url"
    t.integer  "id_establecimiento"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "tipos", force: true do |t|
    t.string   "nombre"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.integer  "evento_id"
  end

  create_table "usuarios", force: true do |t|
    t.string   "nombre"
    t.string   "foto"
    t.string   "username"
    t.string   "facebook"
    t.string   "twitter"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.string   "current_sign_in_ip"
    t.string   "last_sign_in_ip"
    t.string   "email"
    t.string   "foto_file_name"
    t.string   "foto_content_type"
    t.integer  "foto_file_size"
    t.datetime "foto_updated_at"
  end

  add_index "usuarios", ["reset_password_token"], name: "index_usuarios_on_reset_password_token", unique: true, using: :btree

end
