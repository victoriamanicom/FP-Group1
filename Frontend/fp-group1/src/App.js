import Navbar from "react-bootstrap/NavBar";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";

function App() {
  return (
    <div className="App">
      <Navbar className="navbarHeader" sticky="top">
        <Navbar.Brand className="navbarTitle" href="">
          <span class="material-icons">privacy_tip</span>
          National Investigation Unit
        </Navbar.Brand>
      </Navbar>
      <SearchBar />
      <CitizenReturn />
    </div>
  );
}

export default App;
