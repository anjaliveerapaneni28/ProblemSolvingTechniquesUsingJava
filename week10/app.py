from flask import Flask, render_template, request,redirect,url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

# Configure the SQLite database
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///site.db"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
db = SQLAlchemy(app)

# Define the database model
class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    email = db.Column(db.String(100), nullable=False, unique=True)

class Professor(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    email = db.Column(db.String(100), nullable=False, unique=True)    

class Specialization(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)

#create the database tables
with app.app_context():
    db.create_all()
@app.route('/')
def index():
    users = User.query.all()
    if users:
        print(type(users[0]))
    else:
        print("No users found.")
    return render_template("dashboard.html", users=users)

@app.route('/add', methods=['GET', 'POST'])
def add_user():
    if request.method == 'POST':
       name = request.form('name')
       email = request.form('email')
       new_user = User(name=name, email=email)
       db.session.add(new_user)
       db.session.commit()
       return redirect(url_for('index'))
    return render_template('add_user.html')

@app.route('/edit/<int:user_id>', methods=['GET', 'POST'])
def edit_user(user_id):
    user = User.query.get(user_id)
    if request.method == 'POST':
        user.name = request.form('name')
        user.email = request.form('email')
        db.session.commit()
        return redirect(url_for('index'))
    return render_template('edit_user.html', user=user)


@app.route('/delete/<int:user_id>', methods=['POST'])
def delete_user(user_id):
    user = User.query.get(user_id)
    if user:
        db.session.delete(user)
        db.session.commit()
    return redirect(url_for('index'))



@app.route("/", methods=["GET", "POST"])
def home():
    return render_template("base.html")

@app.route("/dashboard")
def dashboard():
    return render_template("dashboard.html")
@app.route("/specialization", methods=["GET", "POST"])
def specialization():
    speclist = Specialization.query.all()

    if request.method == "POST":
        # Adding new specialization
        nameval = request.form.get("specialization_name")
        if nameval:
            new_specialization = Specialization(name=nameval)
            db.session.add(new_specialization)
            db.session.commit()
        return redirect(url_for("specialization"))

    return render_template("specialization.html", speclist=speclist)


# ---------- EDIT ----------
@app.route("/specialization/edit/<int:id>", methods=["GET", "POST"])
def edit_specialization(id):
    specialization = Specialization.query.get_or_404(id)

    if request.method == "POST":
        specialization.name = request.form.get("specialization_name")
        db.session.commit()
        return redirect(url_for("specialization"))

    return render_template("edit_specialization.html", specialization=specialization)


# ---------- DELETE ----------
@app.route("/specialization/delete/<int:id>", methods=["POST"])
def delete_specialization(id):
    specialization = Specialization.query.get_or_404(id)
    db.session.delete(specialization)
    db.session.commit()
    return redirect(url_for("specialization"))

@app.route("/professor", methods=["GET", "POST"])
def professor():
    speclist = Professor.query.all()
    print(request.method)

    if request.method == 'POST':
        nameval = request.form['professor_name']
        print("this is name", nameval)

        new_professor = Professor(name=nameval)
        db.session.add(new_professor)
        db.session.commit()

        return redirect(url_for('professor'))

    return render_template("professor.html", speclist=speclist)



@app.route("/college")
def college ():
    return render_template("college.html")



if __name__ == "__main__":
    app.run(debug=True)