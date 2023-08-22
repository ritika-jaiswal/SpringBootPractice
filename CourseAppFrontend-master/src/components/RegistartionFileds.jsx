import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from '@mui/material/Button';
import { useNavigate } from "react-router-dom";
import CourseServices from "../services/CourseServices";

const RegistrationFields = () =>{
  
    // const [isLogin, setIsLogin] = useState(false);
    // let setIsLogin = false;
    // useEffect(() => {

    // },[isLogin])
    const handleChange = (e) => {
      const value = e.target.value;
      SetUserData({ ...userData, [e.target.name]: value });
    };
    const [userData, SetUserData] = useState({
      name: "",
      email: "",
      password: "",
      about: "",
      role: ""
    });
  
    const navigate = useNavigate();
    const handleSignIn = (e) => {
      // console.log(e.target.value)
      e.preventDefault();
      CourseServices.saveUserData(userData)
        .then((response) => {
          console.log(response);
          navigate("/login");
        })
        .catch((error) => {
          console.log(error);
        });
    };
    const handleClickChange = (e) => {
      navigate("/login");
    }
    return(
        <>
         <Box>
        <h1 className="flex justify-center items-center text-lg mt-3 text-white font-semibold">Sign-In</h1>
        <div className="flex ml-60 mt-2 mx-80 w-[80%] h-[88%] ">
        <div className="flex-col  bg-slate-100 shadow-lg border-4 rounded-2xl">
          <div className="flex-col pt-2 px-4">Enter your name:
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="name"
              value={userData.name}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
          <div className="flex-col pt-2 px-4">Enter your email:
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="email"
              value={userData.email}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
           <div className="flex-col pt-2 px-4">Enter new password:
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="password"
              value={userData.password}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
          <div className="flex-col pt-2 px-4">About:
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="about"
              value={userData.about}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
          <div className="flex-col pt-2 px-4">Enter your Role:
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="role"
              value={userData.role}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
         
          
          <div className=" flex my-4 justify-center">
          <Button variant="contained" style={{background:"blue-400"}} onClick={handleSignIn}>Sing-in</Button>
          </div>
          <div className="flex justify-center items-center pb-4 -pt-4">
            If you'r already registered, 
            <Button onClick={handleClickChange}>login</Button>
          </div>
          {/* <div> <Authentication data = {setIsLogin}/></div> */}
        
        </div>
      
        </div>
        
      </Box> 
        </>
    )
}

export default RegistrationFields