import React from "react";
import RegistrationFields from "./RegistartionFileds";



const Registration = () => {
    
  return (
    <div className="flex w-screen h-screen bg-gradient-to-r from-indigo-800 from-10% via-sky-600 via-30% to-gray-600 to-90% ...">
        <div className="flex w-[50%]">
            <img src="https://img.freepik.com/free-vector/two-factor-authentication-concept-illustration_114360-5488.jpg?w=2000" alt='logo'/>
        </div>
          <RegistrationFields />

        </div>
   
  );
};

export default Registration;
