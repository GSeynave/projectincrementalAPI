class User {

    constructor(id, username, personnages, zone) {
        this.id = id;
        this.username = username;
        this.personnages = personnages;
    }

    get id() {
        return this.id;
    }
    get username() {
        return this.username;
    }
    get personnages() {
        return this.personnages;
    }
}