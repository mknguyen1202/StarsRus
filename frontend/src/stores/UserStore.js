import {extendObservable} from 'mobx';

// User Store
class UserStore{
    constructor(){
        extendObservable(this,{ //contains properties
            loading: true,
            isLoggedIn: false,
            username: ''
        })
    }   
}

export default new UserStore();