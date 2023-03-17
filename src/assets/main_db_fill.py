import subprocess;

subprocess.call(['python', 'bookstore/src/assets/fill_user_db.py'])
subprocess.call(['python', 'bookstore/src/assets/fill_book_db.py'])
subprocess.call(['python', 'bookstore/src/assets/fill_copy_db.py'])
subprocess.call(['python', 'bookstore/src/assets/fill_reservation_db.py'])