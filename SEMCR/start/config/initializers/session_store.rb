# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_start_session',
  :secret      => '10f0410781ae069fed16368f1f727294bd2cdda8208a59e930f2c0ab10fdb74d476ec11e2b5fa8451bb36dd6d3f0a8680b2650a21f6241cf7f460518b0df4919'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
