import { useState } from "react";
import Greeting from "./components/Greeting";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";
import FlightDetails from "./components/FlightDetails";
import BookTicket from "./components/BookTicket";
import "./App.css";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="App">
      <Greeting isLoggedIn={isLoggedIn} />
      {isLoggedIn ? (
        <>
          <LogoutButton onClick={handleLogout} />
          <BookTicket />
        </>
      ) : (
        <>
          <LoginButton onClick={handleLogin} />
          <FlightDetails />
        </>
      )}
    </div>
  );
}

export default App;