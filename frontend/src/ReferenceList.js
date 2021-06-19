import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar';
import { Link } from 'react-router-dom';
import './App.css';
class ReferenceList extends Component{
    constructor(props) {
        super(props);
        this.state = {references: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/reference')
            .then(response => response.json())
            .then(data => this.setState({references: data}));
    }

    async remove(id) {
        await fetch(`/reference/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedRefs = [...this.state.references].filter(i => i.id !== id);
            this.setState({references: updatedRefs});
        });
    }

    render() {
        const {references, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const refList = references.map(ref => {
            return <tr key={ref.id}>
                <td style={{whiteSpace: 'nowrap'}}>{ref.createDate}</td>
                <td style={{whiteSpace: 'nowrap'}}>{ref.head}</td>
                <td> <a href={ref.reference}>{ref.reference}</a></td>
                <td>{ref.description}</td>
                <td>
                    <ButtonGroup>
                        <div id='button'>
                        <Button size="sm" color="primary" tag={Link} to={"/reference/" + ref.id}>Edit</Button>
                        </div>
                        <Button size="sm" color="danger" onClick={() => this.remove(ref.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/reference/new">Добавить</Button>
                    </div>
                    <h3>Хранилище ссылок</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="10%">Дата</th>
                            <th width="20%">Заголовок</th>
                            <th width="30%">Ссылка</th>
                            <th width="30%">Описание</th>
                            <th width="10%">Действия</th>
                        </tr>
                        </thead>
                        <tbody>
                        {refList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default ReferenceList;
