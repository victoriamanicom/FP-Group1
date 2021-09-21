import Col from 'react-bootstrap/Col';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import './SearchBar.css';

const SearchBar = ({handleSearch, handleReset}) => {

    return (
        <>
            <form id="searchBarForm" onSubmit={handleSearch}>
                <Col md>
                    <FloatingLabel controlId="floatingForenames" label="Forenames">
                        <Form.Control type="text" name="searchForenames"/>
                    </FloatingLabel>
                </Col>
                <Col md>
                    <FloatingLabel controlId="floatingSurname" label="Surname">
                        <Form.Control type="text" name="searchSurname"/>
                    </FloatingLabel>
                </Col>
                <Col md>
                    <FloatingLabel controlId="floatingGender" label="Gender">
                        <Form.Select>
                            <option value="Female"></option>
                            <option value="Male"></option>
                            <option value="Unknown"></option>
                        </Form.Select>
                    </FloatingLabel>
                </Col>
                
            </form>
        </>
    )

}

export default SearchBar;