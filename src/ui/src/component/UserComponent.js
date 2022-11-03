import React from 'react';
import UserService from '../service/UserService';
import {DisplayBoard} from "./DisplayBoard";

class UserComponent extends React.Component {


    constructor(props){
        super(props)
        this.state = {
            users: [],
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> Snakes and Ladders</h1>
                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td> User Id</td>
                        <td> User Name</td>
                        <td> User Position</td>
                        <td> Last Roll</td>
                    </tr>

                    </thead>
                    <tbody>
                    {
                        this.state.users.map(
                            user =>
                                <tr key = {user.id}>
                                    <td> {user.id}</td>
                                    <td> {user.name}</td>
                                    <td> {user.position}</td>
                                    <td> {user.roll}</td>
                                </tr>
                        )
                    }

                    </tbody>
                </table>
            </div>

        )
    }
}

export default UserComponent