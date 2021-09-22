import Navbar from "react-bootstrap/NavBar";
import "material-icons/iconfont/material-icons.css";
<<<<<<< Updated upstream
import "./App.css";
=======
import SearchBar from "./components/searchBar/SearchBar";
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";
>>>>>>> Stashed changes

function App() {
  return (
    <div className="App">
<<<<<<< Updated upstream
      <Navbar className="navbarHeader" fixed="top">
        <Navbar.Brand href="">
=======
      <Navbar className="navbarHeader" sticky="top">
        <Navbar.Brand className="navbarTitle" href="">
>>>>>>> Stashed changes
          <span class="material-icons">privacy_tip</span>
          National Investigation Unit
        </Navbar.Brand>
      </Navbar>
<<<<<<< Updated upstream
=======
      <SearchBar />
      <CitizenReturn />
>>>>>>> Stashed changes
    </div>
  );
}

export default App;
