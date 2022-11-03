import React from 'react'
import UserService from "../service/UserService";

const USERS_REST_API_URL = 'http://localhost:8080/api/users';


export const DisplayBoard = ({numberOfUsers}) => {
    
    return(
        <div className="display-board">
            <h4>Dice Value</h4>
            <div className="number">
            {numberOfUsers}
            </div>
            <div className="btn">
                <button type="button" onClick={(e) => UserService.getUsers()} className="btn btn-warning">Roll the Dice</button>
            </div>
        </div>
    )
}