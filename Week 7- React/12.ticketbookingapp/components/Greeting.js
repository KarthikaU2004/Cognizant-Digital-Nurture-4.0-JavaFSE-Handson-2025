import GuestGreeting from "./GuestGreeting";
import UserGreeting from "./UserGreeting";

export default function Greeting({ isLoggedIn }) {
  return isLoggedIn ? <UserGreeting /> : <GuestGreeting />;
}