import './SearchBar.css';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';

const SearchBar = ({handleSearch, handleReset}) => {

    return (
        <>
            <Form id="searchBarForm" onSubmit={handleSearch}>
                <Row>
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
                </Row>
                
            </Form>
        </>
    )

}

export default SearchBar;