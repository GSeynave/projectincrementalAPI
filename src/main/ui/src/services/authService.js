class AuthService {

    getHeaders() {

        if (localStorage.authToken != null) {
            return {
                headers: { 
                    Authorization: `Bearer ${localStorage.authToken}`,
                }
            };
        }
    }

}

export default new AuthService();
