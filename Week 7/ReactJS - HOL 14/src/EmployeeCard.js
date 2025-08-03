import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext); // 🎯 context unlocked!

  const buttonStyle =
    theme === "light"
      ? { backgroundColor: "white", color: "black" }
      : { backgroundColor: "black", color: "white" };

  return (
    <div style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}>
      <h3>{employee.name}</h3>
      <p>Role: {employee.role}</p>
      <button style={buttonStyle}>Contact</button>
    </div>
  );
};

export default EmployeeCard;