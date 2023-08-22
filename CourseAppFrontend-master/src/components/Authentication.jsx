import React from "react";
import Registration from "./Registration";
import Login from "./Login";

const Authentication = (props) => {
    console.log(props.data)
    return(
        <>
        <Registration/>
        {/* <Login/> */}
        </>
      )
}
export default Authentication;