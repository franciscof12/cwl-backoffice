'use client'
import React, { useEffect, useState } from 'react';


export default function Page() {
    const [data, setData] = useState([]);
    useEffect(() => {
        // Realiza el fetch de los datos al montar el componente
        fetch('http://localhost:8080/sourcecontent')
            .then((response) => response.json()) // Convierte la respuesta en JSON
            .then((jsonData) => {
                setData(jsonData); // Almacena los datos en el estado
            })
            .catch((error) => {
                console.error('Error fetching data: ', error); // Maneja posibles errores
            });
    }, []);
    console.log(data);

    return (
        <div className="flex flex-col">
            <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div className="inline-block min-w-full py-2 sm:px-6 lg:px-8">
                <h1 className=" text-2xl text-color-ui-crema_black p-5 pl-2 font-semibold">Sources Content</h1>
                    <div className="overflow-hidden">
                        <table
                            className="min-w-full text-center text-sm font-light text-surface text-color-ui-crema_black">
                            <thead
                                className="border-b border-neutral-200 bg-neutral-100/90 font-medium dark:border-white/10 text-color-ui-crema_black">
                                <tr>
                                    <th scope="col" className=" px-6 py-4">Country</th>
                                    <th scope="col" className=" px-6 py-4">Vertical</th>
                                    <th scope="col" className=" px-6 py-4">Source</th>
                                    <th scope="col" className=" px-6 py-4">Type</th>
                                    <th scope="col" className=" px-6 py-4">HDFS Whrite</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr className="border-b border-neutral-200 dark:border-white/10">
                                    <td className="whitespace-nowrap  px-6 py-4 font-medium">1</td>
                                    <td className="whitespace-nowrap  px-6 py-4">Mark</td>
                                    <td className="whitespace-nowrap  px-6 py-4">Otto</td>
                                    <td className="whitespace-nowrap  px-6 py-4">@mdo</td>
                                    <td className="whitespace-nowrap  px-6 py-4">@mdo</td>
                                </tr>
                                <tr className="border-b border-neutral-200 dark:border-white/10">
                                    <td className="whitespace-nowrap  px-6 py-4 font-medium">2</td>
                                    <td className="whitespace-nowrap  px-6 py-4 ">Jacob</td>
                                    <td className="whitespace-nowrap  px-6 py-4">Thornton</td>
                                    <td className="whitespace-nowrap  px-6 py-4">@fat</td>
                                    <td className="whitespace-nowrap  px-6 py-4">@fat</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    )
}