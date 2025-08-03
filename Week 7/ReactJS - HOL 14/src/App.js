import React, { useState } from "react";
import EmployeesList from "./EmployeesList";
import ThemeContext from "./ThemeContext";

const App = () => {
  const [theme, setTheme] = useState("light");

  const toggleTheme = () =>
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee Management</h1>
        <button onClick={toggleTheme}>Toggle Theme</button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
};

export default App;