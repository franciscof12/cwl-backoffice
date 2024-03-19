'use client'
import React, {useEffect, useState} from 'react';
// @ts-ignore
import {SourcesContent} from '@/app/promises/interfaces';

export default function Page() {
    const [data, setData] = useState<SourcesContent[]>([]);
    useEffect(() => {
        fetch('http://localhost:8080/sourcecontent')
            .then(response => response.json())
            .then(data => setData(data));
    }, []);
    return (
        <div className="p-4 h-full w-full rounded-md">
            <div className="grid grid-cols-8 grid-rows-10 gap-4 h-full w-full">
                <div className="col-span-2 row-span-2 rounded-xl isolate backdrop-blur-sm bg-neutral-100/50">
                    <div className="col-span-2 row-span-2 row-start-2">
                        <h1 className={'text-color-ui-crema_black font-semibold text-xl text-center pt-1'}>New Sources</h1>
                        <p
                            className={'text-color-ui-crema_black font-bold text-6xl pt-4 text-center'}><strong
                        className={'text-green-600/20'}>+</strong>4.545</p></div>
                    <div className={'flex justify-between text-neutral-800/30 text-xs p-4'}>
                        <div className="row-start-4">This month</div>
                        <div className="row-start-4"></div>
                    </div>
                </div>

                <div
                    className="col-span-2 row-span-2 col-start-3  rounded-xl isolate backdrop-blur-sm bg-neutral-100/50">
                    <div className="col-span-2 row-span-2 row-start-2">
                        <h1 className={'text-color-ui-crema_black font-semibold text-xl text-center pt-1'}>Banned Sources</h1>
                        <p
                            className={'text-color-ui-crema_black font-bold text-6xl pt-4 text-center'}><strong
                            className={'text-red-600/20'}>-</strong>342</p></div>
                    <div className={'flex justify-between text-neutral-800/30 text-xs p-4'}>
                        <div className="row-start-4">This month</div>
                        <div className="row-start-4"></div>
                    </div>
                </div>
                <div
                    className="col-span-2 row-span-2 col-start-5  rounded-xl isolate backdrop-blur-sm bg-neutral-100/50">
                    <div className="col-span-2 row-span-2 row-start-2">
                        <h1 className={'text-color-ui-crema_black font-semibold text-xl text-center pt-1'}>Source Metrics</h1>
                        <p
                            className={'text-color-ui-crema_black font-bold text-6xl pt-4 text-center'}><strong
                            className={'text-green-600/20'}>+</strong>45</p></div>
                    <div className={'flex justify-between text-neutral-800/30 text-xs p-4'}>
                        <div className="row-start-4">This month</div>
                        <div className="row-start-4"></div>
                    </div>
                </div>
                <div
                    className="col-span-2 row-span-2 col-start-7  rounded-xl isolate backdrop-blur-sm bg-neutral-100/50">
                    <div className="col-span-2 row-span-2 row-start-2">
                        <h1 className={'text-color-ui-crema_black font-semibold text-xl text-center pt-1'}>Source Metrics</h1>
                        <p
                            className={'text-color-ui-crema_black font-bold text-6xl pt-4 text-center'}><strong
                            className={'text-green-600/20'}>+</strong>20</p></div>
                    <div className={'flex justify-between text-neutral-800/30 text-xs p-4'}>
                        <div className="row-start-4">This month</div>
                        <div className="row-start-4"></div>
                    </div>
                </div>
                <div className="col-span-8 row-span-8 row-start-3">
                    <div className="flex flex-col text-color-ui-crema_black">
                        <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                            <div className="inline-block min-w-full py-2 sm:px-6 lg:px-8">
                                <div className="overflow-hidden">
                                    <table
                                        className="min-w-full text-left text-sm font-light text-surface">
                                        <thead
                                            className="border-b border-neutral-200 font-medium">
                                        <tr>
                                            <th scope="col" className="px-6 py-4 font-semibold">Country</th>
                                            <th scope="col" className="px-6 py-4 font-semibold">Source</th>
                                            <th scope="col" className="px-6 py-4 font-semibold">Vertical</th>
                                            <th scope="col" className="px-6 py-4 font-semibold">Type</th>
                                            <th scope="col" className="px-6 py-4 font-semibold">WritesHDFS</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        {data.map((item, index) => (
                                            <tr key={index}
                                                className="border-b border-neutral-200 transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-white/10 dark:hover:bg-neutral-300/80 dark:hover:text-color-ui-crema_black">
                                                <td className="whitespace-nowrap px-6 py-4">{item.country}</td>
                                                <td className="whitespace-nowrap px-6 py-4">{item.source}</td>
                                                <td className="whitespace-nowrap px-6 py-4">{item.vertical}</td>
                                                <td className="whitespace-nowrap px-6 py-4">{item.crawlingType}</td>
                                                <td className="whitespace-nowrap px-6 py-4">{item.writesHDFS ?
                                                    <p className='text-green-600/90 font-semibold'>Yes</p> :
                                                    <p className='text-red-600/90 font-semibold'>No</p>}</td>
                                            </tr>
                                        ))}
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}